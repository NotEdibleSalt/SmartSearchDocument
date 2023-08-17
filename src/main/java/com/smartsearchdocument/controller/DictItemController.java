package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.DictItemDO;
import com.smartsearchdocument.service.DictItemService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import com.smartsearchdocument.dto.command.SaveDictItemCommand;
import com.smartsearchdocument.dto.query.DictItemPaging;

/**
 * 字典项Controller
 *
 * @author NotEdibleSalt

 */

@Slf4j
@RestController
@RequestMapping("dicts/items")
@AllArgsConstructor
public class DictItemController {

    private final DictItemService dictItemService;

    /**
     * 添加字典项
     *
     * @param saveDictItemCommand 保存字典项DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.DictItemDO>
     * @author NotEdibleSalt
     */
    @PostMapping("")
    public Result<DictItemDO> addDictItem(@RequestBody SaveDictItemCommand saveDictItemCommand) {

        DictItemDO dictItemDO = dictItemService.addDictItem(saveDictItemCommand);
        return Result.success(dictItemDO);
    }

    /**
     * 修改角色
     *
     * @param id                  id
     * @param saveDictItemCommand 保存字典项DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.DictItemDO>
     * @author NotEdibleSalt
     */
    @PutMapping("{id}")
    public Result<DictItemDO> updateDictItem(@PathVariable("id") String id, @RequestBody SaveDictItemCommand saveDictItemCommand) {

        DictItemDO dictItemDO = dictItemService.updateDictItem(id, saveDictItemCommand);
        return Result.success(dictItemDO);
    }


    /**
     * 查询字典项
     *
     * @param id 字典项id
     * @return cn.exrick.xboot.common.vo.Result<com.smartsearchdocument.entity.DictItemDO>
     * @author NotEdibleSalt
    
     */
    @GetMapping("{id}")
    public Result<DictItemDO> getDictItemById(@PathVariable("id") String id) {

        DictItemDO dictItemDO = dictItemService.getDictItemById(id);
        return Result.success(dictItemDO);
    }


    /**
     * 删除角色
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.DictItem>
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<DictItemDO> delDictItem(@PathVariable("id") String id) {

        dictItemService.delDictItem(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }
}
