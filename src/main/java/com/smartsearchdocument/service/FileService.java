package com.smartsearchdocument.service;

import com.smartsearchdocument.dos.FileDO;
import com.smartsearchdocument.dto.query.FilePagingDTO;
import com.smartsearchdocument.dto.command.UploadFileDTO;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件表Service
 *
 * @author NotEdibleSalt
 */
@Valid
public interface FileService {

    /**
     * 查询文件表 通过id
     *
     * @param id 文件表id
     * @return com.smartsearchdocument.entity.FileDO
     * @author NotEdibleSalt
     */
    FileDO getFileDOById(String id);

    /**
     * 分页查询文件表
     *
     * @param filePagingDTO 分页查询文件表参数
     * @param pageVo        分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.entity.FileDO>
     * @author NotEdibleSalt
     */
    Page<FileDO> filePaging(FilePagingDTO filePagingDTO, Pageable pageVo);


    /**
     * 上传文件
     *
     * @param file          文件
     * @param uploadFileDTO 上传文件参数
     * @return com.smartsearchdocument.dos.FileDO
     * @author NotEdibleSalt
     */
    FileDO uploadFile(MultipartFile file, @Validated UploadFileDTO uploadFileDTO);

    /**
     * 删除文件
     *
     * @param id 文件id
     * @author NotEdibleSalt
     */
    void delFile(String id);
}
