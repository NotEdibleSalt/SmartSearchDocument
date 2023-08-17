package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.RoleDO;
import com.smartsearchdocument.dto.query.RolePagingDTO;
import com.smartsearchdocument.dto.command.SaveRoleCommand;
import com.smartsearchdocument.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

/**
 * 角色表Controller
 *
 * @author NotEdibleSalt
 */
 
@Slf4j
@RestController
@RequestMapping("roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;


    /**
     * 添加角色
     *
     * @param saveRoleCommand 添加角色DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleDO>
     * @author NotEdibleSalt
     */
    @PostMapping("")
    public Result<RoleDO> addRole(@RequestBody SaveRoleCommand saveRoleCommand) {

        RoleDO roleDO = roleService.addRole(saveRoleCommand);
        return Result.success(roleDO);
    }

    /**
     * 修改角色
     *
     * @param id id
     * @param saveRoleCommand 添加角色DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleDO>
     * @author NotEdibleSalt
     */
    @PutMapping("{id}")
    public Result<RoleDO> updateRole(@PathVariable("id") String id, @RequestBody SaveRoleCommand saveRoleCommand) {

        RoleDO roleDO = roleService.updateRole(id, saveRoleCommand);
        return Result.success(roleDO);
    }
    
    /**
     * 查询角色表 
     *
     * @param id 角色表id
     * @return cn.exrick.xboot.common.vo.Result<com.smartsearchdocument.entity.RoleDO>
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<RoleDO> getRoleById(@PathVariable("id") String id) {

       RoleDO roleDO = roleService.getRoleById(id);
       return Result.success(roleDO);
    }


    /**
     * 分页查询角色表
     *
     * @param rolePagingDTO 分页查询角色表参数
     * @param pageVo 分页查询参数
     * @return cn.exrick.xboot.common.vo.Result<org.springframework.data.domain.Page<com.smartsearchdocument.entity.Role>>
     * @author NotEdibleSalt
     */   
    @GetMapping("")
    public  Result<Page<RoleDO>> rolePaging(RolePagingDTO rolePagingDTO, Pageable pageVo) {

       Page<RoleDO> page = roleService.rolePaging(rolePagingDTO, pageVo);
       return Result.success(page);
    }

    /**
     * 删除角色
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleDO>
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<RoleDO> delRole(@PathVariable("id") String id) {

        roleService.delRole(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }

}
