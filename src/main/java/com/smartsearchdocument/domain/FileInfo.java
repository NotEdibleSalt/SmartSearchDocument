package com.smartsearchdocument.domain;

import com.smartsearchdocument.dos.FileDO;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 文档
 *
 * @author NotEdibleSalt
 */
@Data
@Document(indexName = "file_info")
public class FileInfo {

    /**
     * 文件id
     */
    @Id
    @Field(type = FieldType.Keyword)
    private String fileId;

    /**
     * 分组id
     */
    @Field(type = FieldType.Keyword)
    private String groupId;

    /**
     * 文件名
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String fileName;

    /**
     * 文件路径
     */
    @Field(type = FieldType.Keyword)
    private String filePath;

    /**
     * 备注
     */
    @Field(type = FieldType.Keyword)
    private String remark;

    /**
     * 内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String content;

    /**
     * 最后修改时间
     */
    @Field(type = FieldType.Date)
    private LocalDate updateTime;

    public static FileInfo from(FileDO fileDO, String fileContent) {

        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileId(fileDO.getId());
        fileInfo.setGroupId(fileDO.getGroupId());
        fileInfo.setFileName(fileDO.getFileName());
        fileInfo.setFilePath(fileDO.getFilePath());
        fileInfo.setRemark(fileDO.getRemark());
        fileInfo.setContent(fileContent);
        fileInfo.setUpdateTime(fileDO.getUpdateTime().toLocalDate());

        return fileInfo;
    }

}
