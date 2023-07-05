package com.smartsearchdocument.es;

import com.smartsearchdocument.domain.FileInfo;
import java.util.List;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * 文件信息es repo
 */
public interface FileInfoES extends ElasticsearchRepository<FileInfo, String> {


    @Highlight(
        fields = {
            @HighlightField(name = "content")
        },
        parameters = @HighlightParameters(
            preTags = "<strong><font style='color:red'>",
            postTags = "</font></strong>",
            fragmentSize = 500,
            numberOfFragments = 3
        )
    )
    List<SearchHit<FileInfo>> findByContent(String content);


}
