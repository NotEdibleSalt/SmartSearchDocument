package com.smartsearchdocument.repo;

import com.smartsearchdocument.dos.DictDO;
import com.smartsearchdocument.common.RepoBaseI;
import java.util.Optional;
import org.apache.commons.io.file.PathUtils;

/**
 * 字典表Repo
 *

 */
public interface DictRepo extends RepoBaseI<DictDO> {

    Optional<DictDO> findByName(String name);

    Optional<DictDO> findByType(String type);
}


