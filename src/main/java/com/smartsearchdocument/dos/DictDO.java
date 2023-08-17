package com.smartsearchdocument.dos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import com.smartsearchdocument.common.DOBase;

/**
 * 字典表DO
 *
 * @author NotEdibleSalt

 */

@Data
@Table("dict")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictDO extends DOBase implements Serializable {


    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否系统内置
     */
    private String system;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    private String status;


}
