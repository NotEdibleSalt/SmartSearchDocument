package com.smartsearchdocument.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 登录参数
 *
 * @author NotEdibleSalt
 */
@Data
public class LoginDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @Length(min = 8, message = "密码长度不能小于8位")
    @NotBlank(message = "密码不能为空")
    private String password;
}
