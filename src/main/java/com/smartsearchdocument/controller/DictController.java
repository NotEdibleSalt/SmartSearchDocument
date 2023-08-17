package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.domain.Dict;
import com.smartsearchdocument.dos.DictDO;
import com.smartsearchdocument.dos.DictItemDO;
import com.smartsearchdocument.service.DictService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import com.smartsearchdocument.dto.command.SaveDictCommand;
import com.smartsearchdocument.dto.query.DictPaging;

/**
 * 字典表Controller
 *
 * @author NotEdibleSalt

 */
 
@Slf4j
@RestController
@RequestMapping("dicts")
@AllArgsConstructor
public class DictController {
    
    private final DictService dictService;

    /**
     * 添加字典表 
     *
     * @param saveDictCommand 保存字典表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.DictDO>
     * @author NotEdibleSalt
     */
    @PostMapping("")
    public Result<DictDO> addDict(@RequestBody SaveDictCommand saveDictCommand) {

        DictDO dictDO = dictService.addDict(saveDictCommand);
        return Result.success(dictDO);
    }

    /**
     * 修改角色
     *
     * @param id id
     * @param saveDictCommand 保存字典表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.DictDO>
     * @author NotEdibleSalt
     */
    @PutMapping("{id}")
    public Result<DictDO> updateDict(@PathVariable("id") String id, @RequestBody SaveDictCommand saveDictCommand) {

        DictDO dictDO = dictService.updateDict(id, saveDictCommand);
        return Result.success(dictDO);
    }

    
    /**
     * 查询字典表 
     *
     * @param id 字典表id
     * @return cn.exrick.xboot.common.vo.Result<com.smartsearchdocument.entity.DictDO>
    
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<DictDO> getDictById(@PathVariable("id") String id) {

       DictDO dictDO = dictService.getDictById(id);
       return Result.success(dictDO);
    }


    /**
     * 分页查询字典表
     *
     * @param dictPaging 分页查询字典表参数
     * @param pageable 分页查询参数
     * @return cn.exrick.xboot.common.vo.Result<org.springframework.data.domain.Page<com.smartsearchdocument.entity.Dict>>
    
     * @author NotEdibleSalt
     */   
    @GetMapping("")
    public  Result<Page<DictDO>> dictPaging(DictPaging dictPaging, Pageable pageable) {

       Page<DictDO> page = dictService.dictPaging(dictPaging, pageable);
       return Result.success(page);
    }

    /**
     * 删除角色
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.Dict>
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<DictDO> delDict(@PathVariable("id") String id) {

        dictService.delDict(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }

    /**
     * 按类型获取字典
     *
     * @param type 类型
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.domain.Dict>
    
     * @author NotEdibleSalt
     */
    @GetMapping("type/{type}")
    public Result<Dict> getDictByType(@PathVariable("type") String type) {

        Dict dict = dictService.getDictByType(type);
        return Result.success(dict);
    }

    /**
     * 查询字典所有的字典项
     *
     * @param id 字典id
     * @return com.smartsearchdocument.common.Result<java.util.List < com.smartsearchdocument.dos.DictItemDO>>
    
     * @author NotEdibleSalt
     */
    @GetMapping("{id}/items")
    public Result<List<DictItemDO>> getAllDictItemsById(@PathVariable("id") String id) {

        List<DictItemDO> list = dictService.getAllDictItemsById(id);
        return Result.success(list);
    }


}
