package com.smartsearchdocument.dos;

import com.smartsearchdocument.common.DOBase;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;


/**
 * 分组DO
 *
 * @author NotEdibleSalt
 */

@Data
@Table("file_group")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FileGroupDO extends DOBase implements Serializable {


    /**
     * 分组名
     */
    private String name;

    /**
     * 排序号
     */
    private Integer sort;


}
