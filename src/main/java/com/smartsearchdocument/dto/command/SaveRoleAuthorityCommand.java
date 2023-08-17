package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.RoleAuthorityDO;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色、权限关联表保存参数
 *
 * @author NotEdibleSalt

 */
@Data
public class SaveRoleAuthorityCommand {


    /**
     * 角色id
     */
    @NotBlank(message = "角色id不能为空")
    private String roleId;

    /**
     * 权限id
     */
    @NotBlank(message = "权限id不能为空")
    private String authorityId;



    public RoleAuthorityDO to( ) {

        RoleAuthorityDO roleAuthorityDO = new RoleAuthorityDO();
        roleAuthorityDO.setRoleId(this.getRoleId());
        roleAuthorityDO.setAuthorityId(this.getAuthorityId());
        return roleAuthorityDO;

    }

    public RoleAuthorityDO update(RoleAuthorityDO roleAuthorityDO) {

        roleAuthorityDO.setRoleId(this.getRoleId());
        roleAuthorityDO.setAuthorityId(this.getAuthorityId());
        return roleAuthorityDO;
    }
}
