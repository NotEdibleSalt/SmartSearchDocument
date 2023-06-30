package com.smartsearchdocument.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * 解析文档
 *
 * @author NotEdibleSalt
 */
public interface ParseDocumentService {

    String getDocumentContent(InputStream inputStream);

    String getDocumentContent(File file);

    String getDocumentContent(String filePath);


    String getDocumentContent(Path path);
}
