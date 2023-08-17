package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.RoleAuthorityDO;
import com.smartsearchdocument.service.RoleAuthorityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import com.smartsearchdocument.dto.command.SaveRoleAuthorityCommand;
import com.smartsearchdocument.dto.query.RoleAuthorityPaging;

/**
 * 角色、权限关联表接口
 *
 * @author NotEdibleSalt

 */

@Slf4j
@RestController
@RequestMapping("roleAuthoritys")
@AllArgsConstructor
public class RoleAuthorityController {

    private final RoleAuthorityService roleAuthorityService;

    /**
     * 添加角色、权限关联表
     *
     * @param saveRoleAuthorityCommand 保存角色、权限关联表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAuthorityDO>
     * @author NotEdibleSalt
    
     */
    @PostMapping("")
    public Result<RoleAuthorityDO> addRoleAuthority(@RequestBody SaveRoleAuthorityCommand saveRoleAuthorityCommand) {

        RoleAuthorityDO roleAuthorityDO = roleAuthorityService.addRoleAuthority(saveRoleAuthorityCommand);
        return Result.success(roleAuthorityDO);
    }

    /**
     * 修改角色、权限关联表
     *
     * @param id                       id
     * @param saveRoleAuthorityCommand 保存角色、权限关联表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAuthorityDO>
     * @author NotEdibleSalt
    
     */
    @PutMapping("{id}")
    public Result<RoleAuthorityDO> updateRoleAuthority(@PathVariable("id") String id, @RequestBody SaveRoleAuthorityCommand saveRoleAuthorityCommand) {

        RoleAuthorityDO roleAuthorityDO = roleAuthorityService.updateRoleAuthority(id, saveRoleAuthorityCommand);
        return Result.success(roleAuthorityDO);
    }


    /**
     * 查询角色、权限关联表
     *
     * @param id 角色、权限关联表id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAuthorityDO>
     * @author NotEdibleSalt
    
     */
    @GetMapping("{id}")
    public Result<RoleAuthorityDO> getRoleAuthorityById(@PathVariable("id") String id) {

        RoleAuthorityDO roleAuthorityDO = roleAuthorityService.getRoleAuthorityById(id);
        return Result.success(roleAuthorityDO);
    }


    /**
     * 分页查询角色、权限关联表
     *
     * @param roleAuthorityPaging 分页查询角色、权限关联表参数
     * @param pageable            分页查询参数
     * @return com.smartsearchdocument.common.Result<org.springframework.data.domain.Page < com.smartsearchdocument.dos.RoleAuthorityDO>>
     * @author NotEdibleSalt
    
     */
    @GetMapping("")
    public Result<Page<RoleAuthorityDO>> roleAuthorityPaging(RoleAuthorityPaging roleAuthorityPaging, Pageable pageable) {

        Page<RoleAuthorityDO> page = roleAuthorityService.roleAuthorityPaging(roleAuthorityPaging, pageable);
        return Result.success(page);
    }

    /**
     * 删除角色、权限关联表
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAuthority>
     * @author NotEdibleSalt
    
     */
    @DeleteMapping("{id}")
    public Result<RoleAuthorityDO> delRoleAuthority(@PathVariable("id") String id) {

        roleAuthorityService.delRoleAuthority(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }
}
