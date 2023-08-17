package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.controller.ro.TreeDataRO;
import com.smartsearchdocument.dos.MenuDO;
import com.smartsearchdocument.dto.command.SaveMenuCommand;
import com.smartsearchdocument.service.MenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 菜单Controller
 *
 * @author NotEdibleSalt
 */

@Slf4j
@RestController
@RequestMapping("menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加菜单
     *
     * @param saveMenuCommand 保存菜单DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.MenuDO>
     * @author NotEdibleSalt
     */
    @PostMapping()
    public Result<MenuDO> addMenu(@RequestBody SaveMenuCommand saveMenuCommand) {

        MenuDO menuDO = menuService.addMenu(saveMenuCommand);
        return Result.success(menuDO);
    }

    /**
     * 修改菜单
     *
     * @param id 菜单id
     * @param saveMenuCommand 保存菜单DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.MenuDO>
     * @author NotEdibleSalt
     */
    @PutMapping("{id}")
    public Result<MenuDO> updateMenu(@PathVariable("id")String id, @RequestBody SaveMenuCommand saveMenuCommand) {

        MenuDO menuDO = menuService.updateMenu(id, saveMenuCommand);
        return Result.success(menuDO);
    }

    /**
     * 查询菜单
     *
     * @param id 菜单id
     * @return cn.exrick.xboot.common.vo.Result<com.smartsearchdocument.entity.MenuDO>
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<MenuDO> getMenuById(@PathVariable("id") String id) {

        MenuDO menuDO = menuService.getMenuById(id);
        return Result.success(menuDO);
    }


    /**
     * 删除菜单
     *
     * @param id 菜单id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.MenuDO>
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<MenuDO> delMenu(@PathVariable("id") String id) {

        menuService.delMenu(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }

    /**
     * 获取菜单树
     *
     * @return com.smartsearchdocument.common.Result<java.util.List < com.smartsearchdocument.controller.ro.TreeDataRO>>
     * @author NotEdibleSalt
     */
    @GetMapping("tree")
    public Result<List<TreeDataRO>> getMenuTree() {

        List<TreeDataRO> treeDataROList = menuService.getMenuTree();
        return Result.success(treeDataROList);
    }
}
