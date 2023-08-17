package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.RoleAccountDO;
import com.smartsearchdocument.service.RoleAccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import com.smartsearchdocument.dto.command.SaveRoleAccountCommand;
import com.smartsearchdocument.dto.query.RoleAccountPaging;

/**
 * 角色、账号关联表接口
 *

 * @author NotEdibleSalt
 */

@Slf4j
@RestController
@RequestMapping("roleAccounts")
@AllArgsConstructor
public class RoleAccountController {

    private final RoleAccountService roleAccountService;

    /**
     * 添加角色、账号关联表
     *
     * @param saveRoleAccountCommand 保存角色、账号关联表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAccountDO>
    
     * @author NotEdibleSalt
     */
    @PostMapping("")
    public Result<RoleAccountDO> addRoleAccount(@RequestBody SaveRoleAccountCommand saveRoleAccountCommand) {

        RoleAccountDO roleAccountDO = roleAccountService.addRoleAccount(saveRoleAccountCommand);
        return Result.success(roleAccountDO);
    }

    /**
     * 修改角色、账号关联表
     *
     * @param id id
     * @param saveRoleAccountCommand 保存角色、账号关联表DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAccountDO>
    
     * @author NotEdibleSalt
     */
    @PutMapping("{id}")
    public Result<RoleAccountDO> updateRoleAccount(@PathVariable("id") String id, @RequestBody SaveRoleAccountCommand saveRoleAccountCommand) {

        RoleAccountDO roleAccountDO = roleAccountService.updateRoleAccount(id, saveRoleAccountCommand);
        return Result.success(roleAccountDO);
    }


    /**
     * 查询角色、账号关联表
     *
     * @param id 角色、账号关联表id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAccountDO>
    
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<RoleAccountDO> getRoleAccountById(@PathVariable("id") String id) {

       RoleAccountDO roleAccountDO = roleAccountService.getRoleAccountById(id);
       return Result.success(roleAccountDO);
    }


    /**
     * 分页查询角色、账号关联表
     *
     * @param roleAccountPaging 分页查询角色、账号关联表参数
     * @param pageable 分页查询参数
     * @return com.smartsearchdocument.common.Result<org.springframework.data.domain.Page<com.smartsearchdocument.dos.RoleAccountDO>>
    
     * @author NotEdibleSalt
     */
    @GetMapping("")
    public  Result<Page<RoleAccountDO>> roleAccountPaging(RoleAccountPaging roleAccountPaging, Pageable pageable) {

       Page<RoleAccountDO> page = roleAccountService.roleAccountPaging(roleAccountPaging, pageable);
       return Result.success(page);
    }

    /**
     * 删除角色、账号关联表
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.RoleAccount>
    
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<RoleAccountDO> delRoleAccount(@PathVariable("id") String id) {

        roleAccountService.delRoleAccount(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }
}
