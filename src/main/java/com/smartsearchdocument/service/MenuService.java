package com.smartsearchdocument.service;

import com.smartsearchdocument.controller.ro.TreeDataRO;
import com.smartsearchdocument.dos.MenuDO;
import com.smartsearchdocument.dto.command.SaveMenuCommand;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;


/**
 * 菜单Service
 *
 * @author NotEdibleSalt
 */
@Validated
public interface MenuService {

    /**
     * 添加菜单
     *
     * @param saveMenuCommand 保存菜单DTO
     * @return com.smartsearchdocument.dos.MenuDO
     * @author NotEdibleSalt
     */
    MenuDO addMenu(@Valid SaveMenuCommand saveMenuCommand);

    /**
     * 修改菜单
     *
     * @param id              菜单id
     * @param saveMenuCommand 保存菜单DTO
     * @return com.smartsearchdocument.dos.MenuDO
     * @author NotEdibleSalt
     */
    MenuDO updateMenu(String id, @Valid SaveMenuCommand saveMenuCommand);

    /**
     * 查询菜单 通过id
     *
     * @param id 菜单id
     * @return com.smartsearchdocument.entity.MenuDO
     * @author NotEdibleSalt
     */
    MenuDO getMenuById(String id);


    /**
     * 删除菜单
     *
     * @param id 菜单id
     * @author NotEdibleSalt
     */
    void delMenu(String id);

    /**
     * 获取菜单树
     *
     * @return java.util.List<com.smartsearchdocument.controller.ro.TreeDataRO>
     * @author NotEdibleSalt
     */
    List<TreeDataRO> getMenuTree();
}
