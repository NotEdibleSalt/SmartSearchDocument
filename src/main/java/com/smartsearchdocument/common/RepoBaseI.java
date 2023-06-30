package com.smartsearchdocument.common;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author NotEdibleSalt
 */
@NoRepositoryBean
public interface RepoBaseI<T extends DOBase> extends PagingAndSortingRepository<T, String> {

    default void logicalDel(String id) {

        findById(id)
            .ifPresent(doBase -> {
                doBase.setNotDel(false);
                save(doBase);
            });
    }
}
