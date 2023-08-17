package com.smartsearchdocument.dto.query;

import lombok.Data;

@Data
public class MenuPagingDTO {


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

    /**
     * 未删除
     */
    private Integer notDel;


}
