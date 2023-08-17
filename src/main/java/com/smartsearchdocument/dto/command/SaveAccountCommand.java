package com.smartsearchdocument.dto.command;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import com.smartsearchdocument.dos.AccountDO;

/**
 * 账户保存参数
 *
 * @author NotEdibleSalt
 */
@Data
public class SaveAccountCommand {


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
    @NotBlank(message = "手机号不能为空")
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    @NotBlank(message = "状态不能为空")
    private String status;


    public AccountDO to( ) {

        AccountDO accountDO = new AccountDO();
        accountDO.setName(this.getName());
        accountDO.setUsername(this.getUsername());
        accountDO.setPhone(this.getPhone());
        accountDO.setEmail(this.getEmail());
        accountDO.setPassword(this.getPassword());
        accountDO.setStatus(this.getStatus());
        return accountDO;

    }

    public AccountDO update(AccountDO accountDO) {

        accountDO.setName(this.getName());
        accountDO.setUsername(this.getUsername());
        accountDO.setPhone(this.getPhone());
        accountDO.setEmail(this.getEmail());
        accountDO.setPassword(this.getPassword());
        accountDO.setStatus(this.getStatus());
        return accountDO;
    }
}
