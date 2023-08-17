package com.smartsearchdocument.service;

import com.smartsearchdocument.dto.command.SaveRoleAccountCommand;
import com.smartsearchdocument.dto.query.RoleAccountPaging;
import com.smartsearchdocument.dos.RoleAccountDO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * 角色、账号关联表Service
 *
 * @author NotEdibleSalt

 */
@Validated
public interface RoleAccountService {

    /**
     * 添加角色、账号关联表
     *
     * @param saveRoleAccountCommand 保存角色、账号关联表DTO
     * @return com.smartsearchdocument.dos.RoleAccountDO
     * @author NotEdibleSalt
    
     */
    RoleAccountDO addRoleAccount(@Valid SaveRoleAccountCommand saveRoleAccountCommand);

    /**
     * 修改角色、账号关联表
     *
     * @param id                     id
     * @param saveRoleAccountCommand 保存角色、账号关联表DTO
     * @return com.smartsearchdocument.dos.RoleAccountDO
     * @author NotEdibleSalt
    
     */
    RoleAccountDO updateRoleAccount(String id, @Valid SaveRoleAccountCommand saveRoleAccountCommand);

    /**
     * 查询角色、账号关联表 通过id
     *
     * @param id 角色、账号关联表id
     * @return com.smartsearchdocument.dos.RoleAccountDO
     * @author NotEdibleSalt
    
     */
    RoleAccountDO getRoleAccountById(String id);

    /**
     * 分页查询角色、账号关联表
     *
     * @param roleAccountPaging 分页查询角色、账号关联表参数
     * @param pageable             分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.dos.RoleAccountDO>
     * @author NotEdibleSalt
    
     */
    Page<RoleAccountDO> roleAccountPaging(RoleAccountPaging roleAccountPaging, Pageable pageable);

    /**
     * 删除角色、账号关联表
     *
     * @param id id
     * @author NotEdibleSalt
    
     */
    void delRoleAccount(String id);

    /**
     * 按账户 ID 获取角色
     *
     * @param accountId 账户 ID
     * @return java.util.List<com.smartsearchdocument.dos.RoleAccountDO>
    
     * @author NotEdibleSalt
     */
    List<RoleAccountDO> getRoleAccountsByAccountId(String accountId);
}
