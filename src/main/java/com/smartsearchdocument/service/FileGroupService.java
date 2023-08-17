package com.smartsearchdocument.service;

import com.smartsearchdocument.dos.FileGroupDO;
import com.smartsearchdocument.dto.query.FileGroupPagingDTO;
import com.smartsearchdocument.dto.command.SaveFileGroup;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;


/**
 * 分组Service
 *
 * @author NotEdibleSalt
 */
@Valid
public interface FileGroupService {

    /**
     * 查询分组 通过id
     *
     * @param id 分组id
     * @return com.smartsearchdocument.entity.FileGroupDO
     * @author NotEdibleSalt
     */
    FileGroupDO getFileGroupById(String id);

    /**
     * 分页查询分组
     *
     * @param fileGroupPagingDTO 分页查询分组参数
     * @param pageVo             分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.entity.FileGroupDO>
     * @author NotEdibleSalt
     */
    Page<FileGroupDO> fileGroupPaging(FileGroupPagingDTO fileGroupPagingDTO, Pageable pageVo);


    FileGroupDO addFileGroup(@Validated SaveFileGroup saveFileGroup);

    FileGroupDO updateFileGroup(String id, @Validated SaveFileGroup saveFileGroup);

}
