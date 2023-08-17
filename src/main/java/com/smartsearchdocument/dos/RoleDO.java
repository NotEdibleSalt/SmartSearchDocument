package com.smartsearchdocument.dos;

import com.smartsearchdocument.common.DOBase;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 角色表DO
 *
 * @author NotEdibleSalt
 */

@Data
@Table("role")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleDO extends DOBase implements Serializable {


    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 状态 1： 启用 2：禁用
     */
    private String status;


}
