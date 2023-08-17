package com.smartsearchdocument.repo;

import com.smartsearchdocument.dos.RoleAuthorityDO;
import com.smartsearchdocument.common.RepoBaseI;
import java.util.Optional;

/**
 * 角色、权限关联表Repo
 *
 * @author NotEdibleSalt

 */
public interface RoleAuthorityRepo extends RepoBaseI<RoleAuthorityDO> {

    Optional<RoleAuthorityDO> findByRoleIdAndAuthorityId(String roleId, String authorityId);
}


