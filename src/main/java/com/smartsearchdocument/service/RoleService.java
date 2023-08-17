package com.smartsearchdocument.service;

import com.smartsearchdocument.dos.RoleDO;
import com.smartsearchdocument.dto.query.RolePagingDTO;
import com.smartsearchdocument.dto.command.SaveRoleCommand;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;


/**
 * 角色表Service
 *
 * @author NotEdibleSalt

 */
@Validated
public interface RoleService {

    /**
     * 添加角色
     *
     * @param saveRoleCommand 添加角色DTO
     * @return com.smartsearchdocument.dos.RoleDO
     * @author NotEdibleSalt
     */
    RoleDO addRole(@Valid SaveRoleCommand saveRoleCommand);

    /**
     * 修改角色
     *
     * @param id              id
     * @param saveRoleCommand 添加角色DTO
     * @return com.smartsearchdocument.dos.RoleDO
     * @author NotEdibleSalt
     */
    RoleDO updateRole(String id, @Valid SaveRoleCommand saveRoleCommand);

    /**
     * 查询角色表 通过id
     *
     * @param id 角色表id
     * @return com.smartsearchdocument.entity.RoleDO
     * @author NotEdibleSalt
     */
    RoleDO getRoleById(String id);

    /**
     * 分页查询角色表
     *
     * @param rolePagingDTO 分页查询角色表参数
     * @param pageVo        分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.entity.RoleDO>
     * @author NotEdibleSalt
     */
    Page<RoleDO> rolePaging(RolePagingDTO rolePagingDTO, Pageable pageVo);


    /**
     * 删除角色
     *
     * @param id id
     * @author NotEdibleSalt
     */
    void delRole(String id);

}
