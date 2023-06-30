package com.smartsearchdocument.repo;

import com.smartsearchdocument.common.RepoBaseI;
import com.smartsearchdocument.dos.AccountDO;
import java.util.Optional;

/**
 * 账户Repo
 */
public interface AccountRepo extends RepoBaseI<AccountDO> {

    Optional<AccountDO> findByUsername(String userName);

}


