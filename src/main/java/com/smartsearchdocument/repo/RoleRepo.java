package com.smartsearchdocument.repo;

import com.smartsearchdocument.common.RepoBaseI;
import com.smartsearchdocument.dos.RoleDO;
import java.util.Optional;

/**
 * 角色表Repo
 */
public interface RoleRepo extends RepoBaseI<RoleDO> {

    Optional<RoleDO> findByName(String name);
}


