package com.smartsearchdocument.dos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import com.smartsearchdocument.common.DOBase;

/**
 * 字典项DO
 *
 * @author NotEdibleSalt

 */

@Data
@Table("dict_item")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictItemDO extends DOBase implements Serializable {


    /**
     * 字典ID
     */
    private String dictId;

    /**
     * 值
     */
    private String value;

    /**
     * 标签
     */
    private String label;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private Integer sort;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    private String status;


}
