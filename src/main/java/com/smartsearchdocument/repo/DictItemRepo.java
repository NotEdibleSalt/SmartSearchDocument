package com.smartsearchdocument.repo;

import com.smartsearchdocument.dos.DictItemDO;
import com.smartsearchdocument.common.RepoBaseI;
import java.util.List;
import java.util.Optional;
import org.apache.commons.io.file.PathUtils;

/**
 * 字典项Repo
 *
 * @author NotEdibleSalt

 */
public interface DictItemRepo extends RepoBaseI<DictItemDO> {

    Optional<DictItemDO> findByLabel(String label);

    List<DictItemDO> findByDictId(String dictId);
}


