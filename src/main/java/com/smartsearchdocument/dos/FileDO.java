package com.smartsearchdocument.dos;

import com.smartsearchdocument.common.DOBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 文件DO
 *
 * @author NotEdibleSalt
 */

@Data
@Table("file")
@EqualsAndHashCode(callSuper = true)
public class FileDO extends DOBase {

    /**
     * 分组id
     */
    private String groupId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 备注
     */
    private String remark;


}
