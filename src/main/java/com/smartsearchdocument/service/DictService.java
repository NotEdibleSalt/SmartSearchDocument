package com.smartsearchdocument.service;

import com.smartsearchdocument.domain.Dict;
import com.smartsearchdocument.dos.DictDO;
import com.smartsearchdocument.dos.DictItemDO;
import com.smartsearchdocument.dto.command.SaveDictCommand;
import com.smartsearchdocument.dto.query.DictPaging;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * 字典表Service
 *
 * @author NotEdibleSalt

 */
@Validated
public interface DictService {

    /**
     * 添加字典表
     *
     * @param saveDictCommand 保存字典表DTO
     * @return com.smartsearchdocument.dos.DictDO
     * @author NotEdibleSalt
    
     */
    DictDO addDict(@Valid SaveDictCommand saveDictCommand);

    /**
     * 修改字典表
     *
     * @param id              id
     * @param saveDictCommand 保存字典表DTO
     * @return com.smartsearchdocument.dos.DictDO
     * @author NotEdibleSalt
    
     */
    DictDO updateDict(String id, @Valid SaveDictCommand saveDictCommand);

    /**
     * 查询字典表 通过id
     *
     * @param id 字典表id
     * @return com.smartsearchdocument.entity.DictDO
     * @author NotEdibleSalt
    
     */
    DictDO getDictById(String id);

    /**
     * 分页查询字典表
     *
     * @param dictPaging 分页查询字典表参数
     * @param pageable      分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.entity.DictDO>
     * @author NotEdibleSalt
    
     */
    Page<DictDO> dictPaging(DictPaging dictPaging, Pageable pageable);

    /**
     * 删除字典表
     *
     * @param id id
     * @author NotEdibleSalt
    
     */
    void delDict(String id);

    /**
     * 按类型获取字典
     *
     * @param type 类型
     * @return com.smartsearchdocument.domain.Dict
    
     * @author NotEdibleSalt
     */
    Dict getDictByType(String type);

    /**
     * 查询字典所有的字典项
     *
     * @param id 字典id
     * @return java.util.List<com.smartsearchdocument.dos.DictItemDO>
    
     * @author NotEdibleSalt
     */
    List<DictItemDO> getAllDictItemsById(String id);



}
