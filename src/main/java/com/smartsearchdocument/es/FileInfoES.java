package com.smartsearchdocument.es;

import com.smartsearchdocument.domain.FileInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * 文件信息es repo
 */
public interface FileInfoES extends ElasticsearchRepository<FileInfo, String> {

}
