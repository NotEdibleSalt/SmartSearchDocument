package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.FileDO;
import com.smartsearchdocument.dto.query.FilePagingDTO;
import com.smartsearchdocument.dto.command.UploadFileDTO;
import com.smartsearchdocument.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件表Controller
 *
 * @author NotEdibleSalt
 */

@Slf4j
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * 查询文件表
     *
     * @param id 文件表id
     * @return cn.exrick.xboot.common.vo.Result<com.smartsearchdocument.entity.FileDO>
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<FileDO> getFileDOById(@PathVariable("id") String id) {

        FileDO fileDO = fileService.getFileDOById(id);
        return Result.success(fileDO);
    }


    /**
     * 分页查询文件表
     *
     * @param filePagingDTO 分页查询文件表参数
     * @param pageVo        分页查询参数
     * @return cn.exrick.xboot.common.vo.Result<org.springframework.data.domain.Page < com.smartsearchdocument.entity.File>>
     * @author NotEdibleSalt
     */
    @GetMapping("filePaging")
    public Result<Page<FileDO>> filePaging(FilePagingDTO filePagingDTO, Pageable pageVo) {

        Page<FileDO> page = fileService.filePaging(filePagingDTO, pageVo);
        return Result.success(page);
    }

    /**
     * 上传文件
     *
     * @param file          文件
     * @param uploadFileDTO 上传文件参数
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.FileDO>
     * @author NotEdibleSalt
     */
    @PostMapping("upload")
    public Result<FileDO> uploadFile(@RequestParam("file") MultipartFile file, UploadFileDTO uploadFileDTO) {

        FileDO fileDO = fileService.uploadFile(file, uploadFileDTO);
        return Result.success(fileDO);
    }

    /**
     * 删除文件
     *
     * @param id 文件id
     * @return com.smartsearchdocument.common.Result<java.lang.Void>
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<Void> delFile(@PathVariable("id") String id) {

        fileService.delFile(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }


}
