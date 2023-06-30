package com.smartsearchdocument.dto;

import lombok.Data;

@Data
public class FileGroupPagingDTO {


    /**
     * 分组名
     */
    private String name;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 未删除
     */
    private Integer notDel;


}
