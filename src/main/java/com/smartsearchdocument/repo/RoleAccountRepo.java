package com.smartsearchdocument.repo;

import com.smartsearchdocument.dos.RoleAccountDO;
import com.smartsearchdocument.common.RepoBaseI;
import java.util.List;
import java.util.Optional;

/**
 * 角色、账号关联表Repo
 *
 * @author NotEdibleSalt

 */
public interface RoleAccountRepo extends RepoBaseI<RoleAccountDO> {

    List<RoleAccountDO> findByRoleIdAndAccountId(String roleId, String accountId);

    List<RoleAccountDO> findByAccountId(String accountId);
}


