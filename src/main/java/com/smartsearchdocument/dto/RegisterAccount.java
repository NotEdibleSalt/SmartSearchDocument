package com.smartsearchdocument.dto;

import com.smartsearchdocument.dos.AccountDO;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 注册账号参数
 */
@Data
public class RegisterAccount {

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
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
    @Length(min = 8, message = "密码长度不能小于8位")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

    public AccountDO to() {

        AccountDO accountDO = new AccountDO();
        accountDO.setName(this.getName());
        accountDO.setUsername(this.getUsername());
        accountDO.setPhone(this.getPhone());
        accountDO.setEmail(this.getEmail());
        accountDO.setPassword(this.getPassword());
        accountDO.setStatus("ENABLE");
        return accountDO;

    }

}
