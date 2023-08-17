package com.smartsearchdocument.dto.query;

import lombok.Data;

@Data
public class AccountPagingDTO {


    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    private String status;

    /**
     * 随机值
     */
    private String random;

}
