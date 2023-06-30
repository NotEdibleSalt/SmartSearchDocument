package com.smartsearchdocument.controller;


import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.FileGroupDO;
import com.smartsearchdocument.dto.SaveFileGroup;
import com.smartsearchdocument.service.FileGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分组Controller
 *
 * @author NotEdibleSalt
 */

@Slf4j
@RestController
@RequestMapping("fileGroup")
public class FileGroupController {

    @Autowired
    private FileGroupService fileGroupService;

    /**
     * 新增文件分组
     *
     * @param saveFileGroup 保存文件分组参数
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.FileGroupDO>
     * @author NotEdibleSalt
     */
    @PostMapping("")
    public Result<FileGroupDO> addFileGroup(@RequestBody SaveFileGroup saveFileGroup) {

        FileGroupDO fileGroupDO = fileGroupService.addFileGroup(saveFileGroup);
        return Result.success(fileGroupDO);
    }

    /**
     * 更新文件分组
     *
     * @param id            id
     * @param saveFileGroup 保存文件分组参数
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.FileGroupDO>
     * @author NotEdibleSalt
     */
    @PutMapping("/{id}")
    public Result<FileGroupDO> updateFileGroup(@PathVariable("id") String id, @RequestBody SaveFileGroup saveFileGroup) {

        FileGroupDO fileGroupDO = fileGroupService.updateFileGroup(id, saveFileGroup);
        return Result.success(fileGroupDO);
    }

}
