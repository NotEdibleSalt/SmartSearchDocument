package com.smartsearchdocument.service.impl;

import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.service.ParseDocumentService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 解析文档实现类
 *
 * @author NotEdibleSalt
 */
@Slf4j
@Service
public class ParseDocumentServiceImpl implements ParseDocumentService {

    @Autowired
    private Tika tika;

    @Override
    public String getDocumentContent(InputStream inputStream) {

        try {

            return tika.parseToString(inputStream);

        } catch (IOException | TikaException e) {
            throw Ex.of("解析文件出现异常", e);
        }
    }

    @Override
    public String getDocumentContent(File file) {

        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        if (!file.isFile()) {
            throw Ex.of("此路径不是文件");
        }

        try (InputStream stream = Files.newInputStream(file.toPath())) {

            return this.getDocumentContent(stream);
        } catch (IOException e) {

            throw Ex.of("解析文件出现异常", e);
        }

    }

    @Override
    public String getDocumentContent(String filePath) {

        Path path = Paths.get(filePath);
        return this.getDocumentContent(path);
    }

    @Override
    public String getDocumentContent(Path path) {

        File file = path.toFile();
        return this.getDocumentContent(file);
    }


}
