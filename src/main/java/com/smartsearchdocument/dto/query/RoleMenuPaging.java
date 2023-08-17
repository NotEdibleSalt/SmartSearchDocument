package com.smartsearchdocument.dto.query;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色、菜单关联表分页查询参数
 *
 * @author NotEdibleSalt

 */
@Data
public class RoleMenuPaging {


    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单id
     */
    private String menuId;

}
