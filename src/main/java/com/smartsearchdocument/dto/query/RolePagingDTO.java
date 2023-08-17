package com.smartsearchdocument.dto.query;

import lombok.Data;

@Data
public class RolePagingDTO {


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

    /**
     * 未删除
     */
    private Integer notDel;


}
