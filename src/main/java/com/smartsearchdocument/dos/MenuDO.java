package com.smartsearchdocument.dos;

import com.smartsearchdocument.common.DOBase;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;


/**
 * 菜单DO
 *
 * @author NotEdibleSalt
 */

@Data
@Table("menu")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MenuDO extends DOBase implements Serializable {


    /**
     * 父菜单id
     */
    private String parentId;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 路由标题
     */
    private String routeName;

    /**
     * 路由路径
     */
    private String routePath;

    /**
     * 排序值
     */
    private Integer sortNumber;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    private String status;

    @Transient
    private String parentName;

}
