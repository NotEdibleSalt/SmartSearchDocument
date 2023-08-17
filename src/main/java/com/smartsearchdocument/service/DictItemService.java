package com.smartsearchdocument.service;

import com.smartsearchdocument.dto.command.SaveDictItemCommand;
import com.smartsearchdocument.dto.query.DictItemPaging;
import com.smartsearchdocument.dos.DictItemDO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * 字典项Service
 *
 * @author NotEdibleSalt

 */
@Validated
public interface DictItemService {

    /**
     * 添加字典项
     *
     * @param saveDictItemCommand 保存字典项DTO
     * @return com.smartsearchdocument.dos.DictItemDO
     * @author NotEdibleSalt
    
     */
    DictItemDO addDictItem(@Valid SaveDictItemCommand saveDictItemCommand);

    /**
     * 修改字典项
     *
     * @param id                  id
     * @param saveDictItemCommand 保存字典项DTO
     * @return com.smartsearchdocument.dos.DictItemDO
     * @author NotEdibleSalt
    
     */
    DictItemDO updateDictItem(String id, @Valid SaveDictItemCommand saveDictItemCommand);

    /**
     * 查询字典项 通过id
     *
     * @param id 字典项id
     * @return com.smartsearchdocument.entity.DictItemDO
     * @author NotEdibleSalt
    
     */
    DictItemDO getDictItemById(String id);


    /**
     * 删除字典项
     *
     * @param id id
     * @author NotEdibleSalt
    
     */
    void delDictItem(String id);

    /**
     * 通过字典id查询所有的字典项
     *
     * @param dictId 字典id
     * @return java.util.List<com.smartsearchdocument.dos.DictItemDO>
    
     * @author NotEdibleSalt
     */
    List<DictItemDO> getByDictId(String dictId);
}
