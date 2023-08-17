package com.smartsearchdocument.repo;

import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.common.RepoBaseI;
import java.util.Optional;

/**
 * 账户Repo
 *
 * @author NotEdibleSalt

 */
public interface AccountRepo extends RepoBaseI<AccountDO> {

    Optional<AccountDO> findByUsername(String userName);

}


