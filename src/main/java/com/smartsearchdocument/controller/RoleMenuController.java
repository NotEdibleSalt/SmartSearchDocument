package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.RoleMenuDO;
import com.smartsearchdocument.service.RoleMenuService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import com.smartsearchdocument.dto.command.SaveRoleMenuCommand;
import com.smartsearchdocument.dto.query.RoleMenuPaging;

/**
 * 角色、菜单关联表接口
 *
 * @author NotEdibleSalt

 */

@Slf4j
@RestController
@RequestMapping("roleMenus")
@AllArgsConstructor
public class RoleMenuController {

    private final RoleMenuService roleMenuService;

    /**
     * 添加角色、菜单关联表
     *
     * @param saveRoleMenuCommand 保存角色、菜单关联表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleMenuDO>
     * @author NotEdibleSalt
    
     */
    @PostMapping("")
    public Result<Void> addRoleMenu(@RequestBody SaveRoleMenuCommand saveRoleMenuCommand) {

        roleMenuService.addRoleMenu(saveRoleMenuCommand);
        return Result.successMsg(Constant.SAVE_SUCCESS_MSG);
    }


    /**
     * 查询角色、菜单关联表
     *
     * @param id 角色、菜单关联表id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleMenuDO>
     * @author NotEdibleSalt
    
     */
    @GetMapping("{id}")
    public Result<RoleMenuDO> getRoleMenuById(@PathVariable("id") String id) {

        RoleMenuDO roleMenuDO = roleMenuService.getRoleMenuById(id);
        return Result.success(roleMenuDO);
    }


    /**
     * 分页查询角色、菜单关联表
     *
     * @param roleMenuPaging 分页查询角色、菜单关联表参数
     * @param pageable       分页查询参数
     * @return com.smartsearchdocument.common.Result<org.springframework.data.domain.Page < com.smartsearchdocument.dos.RoleMenuDO>>
     * @author NotEdibleSalt
    
     */
    @GetMapping("")
    public Result<Page<RoleMenuDO>> roleMenuPaging(RoleMenuPaging roleMenuPaging, Pageable pageable) {

        Page<RoleMenuDO> page = roleMenuService.roleMenuPaging(roleMenuPaging, pageable);
        return Result.success(page);
    }

    /**
     * 删除角色、菜单关联表
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleMenu>
     * @author NotEdibleSalt
    
     */
    @DeleteMapping("{id}")
    public Result<RoleMenuDO> delRoleMenu(@PathVariable("id") String id) {

        roleMenuService.delRoleMenu(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }
}
