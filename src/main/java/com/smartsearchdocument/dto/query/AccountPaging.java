package com.smartsearchdocument.dto.query;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户分页查询参数
 *
 * @author NotEdibleSalt

 */
@Data
public class AccountPaging {


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
     * 未删除
     */
    private Integer notDel;


}
