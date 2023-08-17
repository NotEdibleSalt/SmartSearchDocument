package com.smartsearchdocument.dos;

import com.smartsearchdocument.common.DOBase;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 角色、菜单关联表DO
 *
 * @author NotEdibleSalt

 */

@Data
@Table("role_menu")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleMenuDO extends DOBase implements Serializable {


    /**
     * 角色id
     */
    private String roleId;

    /**
     * 菜单id
     */
    private String menuId;


}
