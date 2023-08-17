package com.smartsearchdocument.service;

import com.smartsearchdocument.dto.command.SaveRoleMenuCommand;
import com.smartsearchdocument.dto.query.RoleMenuPaging;
import com.smartsearchdocument.dos.RoleMenuDO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * 角色、菜单关联表Service
 *
 * @author NotEdibleSalt

 */
@Validated
public interface RoleMenuService {

    /**
     * 添加角色、菜单关联表
     *
     * @param saveRoleMenuCommand 保存角色、菜单关联表DTO
     * @author NotEdibleSalt
    
     */
    void addRoleMenu(@Valid SaveRoleMenuCommand saveRoleMenuCommand);


    /**
     * 查询角色、菜单关联表 通过id
     *
     * @param id 角色、菜单关联表id
     * @return com.smartsearchdocument.dos.RoleMenuDO
     * @author NotEdibleSalt
    
     */
    RoleMenuDO getRoleMenuById(String id);

    /**
     * 分页查询角色、菜单关联表
     *
     * @param roleMenuPaging 分页查询角色、菜单关联表参数
     * @param pageable          分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.dos.RoleMenuDO>
     * @author NotEdibleSalt
    
     */
    Page<RoleMenuDO> roleMenuPaging(RoleMenuPaging roleMenuPaging, Pageable pageable);

    /**
     * 删除角色、菜单关联表
     *
     * @param id id
     * @author NotEdibleSalt
    
     */
    void delRoleMenu(String id);

    /**
     * 按角色 ID 获取角色菜单
     *
     * @param roleId 角色id
     * @return java.util.List<com.smartsearchdocument.dos.RoleMenuDO>
    
     * @author NotEdibleSalt
     */
    List<RoleMenuDO> getRoleMenusByRoleId(String roleId);
}
