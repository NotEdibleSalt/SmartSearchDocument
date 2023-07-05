package com.smartsearchdocument.service;

import com.smartsearchdocument.domain.FileInfo;
import java.util.List;
import javax.validation.Valid;
import org.springframework.data.elasticsearch.core.SearchHit;

/**
 * 智能搜索
 *
 * @author NotEdibleSalt
 */
@Valid
public interface SmartSearchService {

    /**
     * 智能搜索
     *
     * @param search 搜索参数
     * @return java.util.List<org.springframework.data.elasticsearch.core.SearchHit < com.smartsearchdocument.domain.FileInfo>>
     */
    List<SearchHit<FileInfo>> smartSearch(String search);

}
