package com.smartsearchdocument.service;

import com.smartsearchdocument.dto.command.SaveRoleAuthorityCommand;
import com.smartsearchdocument.dto.query.RoleAuthorityPaging;
import com.smartsearchdocument.dos.RoleAuthorityDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * 角色、权限关联表Service
 *
 * @author NotEdibleSalt

 */
@Validated
public interface RoleAuthorityService {

    /**
     * 添加角色、权限关联表
     *
     * @param saveRoleAuthorityCommand 保存角色、权限关联表DTO
     * @return com.smartsearchdocument.dos.RoleAuthorityDO
     * @author NotEdibleSalt
    
     */
    RoleAuthorityDO addRoleAuthority(@Valid SaveRoleAuthorityCommand saveRoleAuthorityCommand);

    /**
     * 修改角色、权限关联表
     *
     * @param id                       id
     * @param saveRoleAuthorityCommand 保存角色、权限关联表DTO
     * @return com.smartsearchdocument.dos.RoleAuthorityDO
     * @author NotEdibleSalt
    
     */
    RoleAuthorityDO updateRoleAuthority(String id, @Valid SaveRoleAuthorityCommand saveRoleAuthorityCommand);

    /**
     * 查询角色、权限关联表 通过id
     *
     * @param id 角色、权限关联表id
     * @return com.smartsearchdocument.dos.RoleAuthorityDO
     * @author NotEdibleSalt
    
     */
    RoleAuthorityDO getRoleAuthorityById(String id);

    /**
     * 分页查询角色、权限关联表
     *
     * @param roleAuthorityPaging 分页查询角色、权限关联表参数
     * @param pageable               分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.dos.RoleAuthorityDO>
     * @author NotEdibleSalt
    
     */
    Page<RoleAuthorityDO> roleAuthorityPaging(RoleAuthorityPaging roleAuthorityPaging, Pageable pageable);

    /**
     * 删除角色、权限关联表
     *
     * @param id id
     * @author NotEdibleSalt
    
     */
    void delRoleAuthority(String id);
}
