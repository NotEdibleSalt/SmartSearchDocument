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
 * 账户DO
 *
 * @author NotEdibleSalt

 */

@Data
@Table("account")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountDO extends DOBase implements Serializable {


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


}
