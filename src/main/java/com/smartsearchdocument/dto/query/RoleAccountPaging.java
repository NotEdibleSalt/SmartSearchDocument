package com.smartsearchdocument.dto.query;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色、账号关联表分页查询参数
 *
 * @author NotEdibleSalt

 */
@Data
public class RoleAccountPaging {


    /**
     * 管理员id
     */
    private String accountId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 未删除
     */
    private Integer notDel;


}
