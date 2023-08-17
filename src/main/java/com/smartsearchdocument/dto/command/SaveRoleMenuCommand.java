package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.RoleMenuDO;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 角色、菜单关联表保存参数
 *
 * @author NotEdibleSalt

 */
@Data
public class SaveRoleMenuCommand {


    /**
     * 角色id
     */
    @NotBlank(message = "角色id不能为空")
    private String roleId;

    /**
     * 菜单id集合
     */
    @NotBlank(message = "菜单id不能为空")
    private String menuIds;


    public List<RoleMenuDO> to() {

        return Arrays.stream(menuIds.split(","))
                     .map(menuId -> {
                         RoleMenuDO roleMenuDO = new RoleMenuDO();
                         roleMenuDO.setRoleId(this.getRoleId());
                         roleMenuDO.setMenuId(menuId);
                         return roleMenuDO;
                     })
                     .collect(Collectors.toList());
    }

}
