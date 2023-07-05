package com.smartsearchdocument.controller;

import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.domain.FileInfo;
import com.smartsearchdocument.service.SmartSearchService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 智能搜素
 *
 * @author NotEdibleSalt
 */
@Slf4j
@RestController
@RequestMapping("search")
public class SmartSearchController {

    @Autowired
    private SmartSearchService smartSearchService;

    /**
     * 智能搜索
     *
     * @param search 搜索参数
     * @return com.smartsearchdocument.common.Result<java.util.List < org.springframework.data.elasticsearch.core.SearchHit < com.smartsearchdocument.domain.FileInfo>>>
     */
    @GetMapping("")
    public Result<List<SearchHit<FileInfo>>> smartSearch(@RequestParam("search") String search) {

        List<SearchHit<FileInfo>> searchHits = smartSearchService.smartSearch(search);
        return Result.success(searchHits);
    }
}
