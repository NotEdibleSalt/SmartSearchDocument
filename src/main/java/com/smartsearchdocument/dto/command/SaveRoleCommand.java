package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.RoleDO;
import lombok.Data;

/**
 * 新增角色DTO
 *
 * @author NotEdibleSalt
 */
@Data
public class SaveRoleCommand {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 状态 启用、禁用
     */
    private String status;

    public RoleDO to() {

        RoleDO roleDO = new RoleDO();
        roleDO.setName(this.getName());
        roleDO.setDescription(this.getDescription());
        roleDO.setStatus(this.getStatus());
        return roleDO;

    }

    public RoleDO update(RoleDO roleDO) {

        roleDO.setName(this.getName());
        roleDO.setDescription(this.getDescription());
        roleDO.setStatus(this.getStatus());
        return roleDO;
    }
}
