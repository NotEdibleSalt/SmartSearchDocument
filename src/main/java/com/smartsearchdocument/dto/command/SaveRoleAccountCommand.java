package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.RoleAccountDO;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色、账号关联表保存参数
 *
 * @author NotEdibleSalt

 */
@Data
public class SaveRoleAccountCommand {


    /**
     * 管理员id
     */
    @NotBlank(message = "管理员id不能为空")
    private String accountId;

    /**
     * 角色id
     */
    @NotBlank(message = "角色id不能为空")
    private String roleId;

    /**
     * 未删除
     */
    @NotBlank(message = "未删除不能为空")
    private Integer notDel;


    public RoleAccountDO to( ) {

        RoleAccountDO roleAccountDO = new RoleAccountDO();
        roleAccountDO.setAccountId(this.getAccountId());
        roleAccountDO.setRoleId(this.getRoleId());
        return roleAccountDO;

    }

    public RoleAccountDO update(RoleAccountDO roleAccountDO) {

        roleAccountDO.setAccountId(this.getAccountId());
        roleAccountDO.setRoleId(this.getRoleId());
        return roleAccountDO;

    }
}
