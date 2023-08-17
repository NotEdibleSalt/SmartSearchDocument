package com.smartsearchdocument.dto.query;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色、权限关联表分页查询参数
 *
 * @author NotEdibleSalt

 */
@Data
public class RoleAuthorityPaging {


    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String authorityId;

    /**
     * 未删除
     */
    private Integer notDel;


}
