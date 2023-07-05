package com.smartsearchdocument.service.impl;

import com.smartsearchdocument.domain.FileInfo;
import com.smartsearchdocument.es.FileInfoES;
import com.smartsearchdocument.service.SmartSearchService;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

/**
 * @author NotEdibleSalt
 */
@Slf4j
@Service
public class SmartSearchServiceImpl implements SmartSearchService {

    @Autowired
    private FileInfoES fileInfoES;


    @Override
    public List<SearchHit<FileInfo>> smartSearch(String search) {

        List<SearchHit<FileInfo>> hitList = fileInfoES.findByContent(search)
                                                      .stream()
                                                      .sorted(Comparator.comparing(SearchHit::getScore))
                                                      .collect(Collectors.toList());

        Collections.reverse(hitList);
        return hitList;
    }
}
