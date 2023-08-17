package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.FileGroupDO;
import com.smartsearchdocument.dto.query.FileGroupPagingDTO;
import com.smartsearchdocument.dto.command.SaveFileGroup;
import com.smartsearchdocument.repo.FileGroupRepo;
import com.smartsearchdocument.service.FileGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 分组ServiceImpl
 */
@Slf4j
@Service
@Transactional
public class FileGroupServiceImpl implements FileGroupService {

    @Autowired
    private FileGroupRepo fileGroupRepo;


    @Override
    public FileGroupDO getFileGroupById(String id) {

        return fileGroupRepo.findById(id)
                            .orElseThrow(() -> Ex.of("分组不存在"));
    }


    @Override
    public Page<FileGroupDO> fileGroupPaging(FileGroupPagingDTO fileGroupPagingDTO, Pageable pageVo) {

        return null;
    }


    @Override
    public FileGroupDO addFileGroup(SaveFileGroup saveFileGroup) {

        FileGroupDO fileGroupDO = saveFileGroup.to();
        return fileGroupRepo.save(fileGroupDO);
    }

    @Override
    public FileGroupDO updateFileGroup(String id, SaveFileGroup saveFileGroup) {

        FileGroupDO fileGroupDO = this.getFileGroupById(id);

        fileGroupDO.setName(saveFileGroup.getName());
        fileGroupDO.setSort(saveFileGroup.getSort());

        return fileGroupRepo.save(fileGroupDO);
    }
}
