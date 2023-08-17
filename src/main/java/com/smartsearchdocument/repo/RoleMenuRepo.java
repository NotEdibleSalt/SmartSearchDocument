package com.smartsearchdocument.repo;

import com.smartsearchdocument.dos.RoleMenuDO;
import com.smartsearchdocument.common.RepoBaseI;
import java.util.List;
import java.util.Optional;

/**
 * 角色、菜单关联表Repo
 *
 * @author NotEdibleSalt

 */
public interface RoleMenuRepo extends RepoBaseI<RoleMenuDO> {

    List<RoleMenuDO> findByRoleIdAndMenuId(String roleId, String menuId);

    List<RoleMenuDO> findByRoleId(String roleId);
}


