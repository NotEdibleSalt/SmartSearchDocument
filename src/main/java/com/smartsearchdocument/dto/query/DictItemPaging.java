package com.smartsearchdocument.dto.query;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 字典项分页查询参数
 *
 * @author NotEdibleSalt

 */
@Data
public class DictItemPaging {


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

    /**
     * 未删除
     */
    private Integer notDel;


}
