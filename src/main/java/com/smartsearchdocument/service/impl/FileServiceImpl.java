package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.domain.FileInfo;
import com.smartsearchdocument.dos.FileDO;
import com.smartsearchdocument.dto.query.FilePagingDTO;
import com.smartsearchdocument.dto.command.UploadFileDTO;
import com.smartsearchdocument.es.FileInfoES;
import com.smartsearchdocument.repo.FileRepo;
import com.smartsearchdocument.repo.dynamic.FileDynamicDao;
import com.smartsearchdocument.service.FileService;
import com.smartsearchdocument.service.ParseDocumentService;
import com.smartsearchdocument.util.SystemUtil;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件表ServiceImpl
 */
@Slf4j
@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepo fileRepo;

    @Autowired
    private FileInfoES fileInfoES;

    @Autowired
    private ParseDocumentService parseDocumentService;

    @Autowired
    private FileDynamicDao fileDynamicDao;

    @Override
    public FileDO getFileDOById(String id) {

        return fileRepo.findById(id)
                       .filter(DOBase::getNotDel)
                       .orElseThrow(() -> Ex.of("文件表不存在"));
    }


    @Override
    public Page<FileDO> filePaging(FilePagingDTO filePagingDTO, Pageable pageable) {

        return fileDynamicDao.filePaging(filePagingDTO, pageable);
    }

    @SneakyThrows
    @Override
    @Transactional
    public FileDO uploadFile(MultipartFile file, UploadFileDTO uploadFileDTO) {

        String rootPath = "/";
        if (SystemUtil.isWindows()) {
            rootPath = "E:";
        }

        String dateStr = LocalDate.now()
                                  .format(DateTimeFormatter.ISO_DATE);
        Path path = Paths.get(rootPath, "root", "file", dateStr);
        Path directories = Files.createDirectories(path);

        int i = 1;
        path = Paths.get(directories.toString(), uploadFileDTO.getFileName());
        while (path.toFile()
                   .exists()) {

            String[] split = uploadFileDTO.getFileName()
                                          .split("\\.");
            split[split.length - 2] = split[split.length - 2] + "-" + i;
            String fileName = String.join(".", split);
            path = Paths.get(directories.toString(), fileName);

            i++;
        }

        FileDO fileDO = new FileDO();
        fileDO.setGroupId(uploadFileDTO.getGroupId());
        fileDO.setFileName(uploadFileDTO.getFileName());
        fileDO.setFilePath(path.toString());
        fileDO.setRemark(uploadFileDTO.getRemark());
        fileDO = fileRepo.save(fileDO);

        InputStream inputStream = file.getInputStream();
        long copy = Files.copy(inputStream, path);
        log.info("保存文件成功，路径: {}，字节: {}", path, copy);

        String content = parseDocumentService.getDocumentContent(path);
        FileInfo fileInfo = FileInfo.from(fileDO, content);
        fileInfoES.save(fileInfo);

        return fileDO;
    }

    @Override
    public void delFile(String id) {

        fileRepo.logicalDel(id);
        fileInfoES.deleteById(id);
        log.info("删除文件，id：{}", id);
    }
}
