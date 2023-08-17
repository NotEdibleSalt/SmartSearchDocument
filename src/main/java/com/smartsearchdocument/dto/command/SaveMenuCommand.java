package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.MenuDO;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 新增菜单
 *
 * @author NotEdibleSalt
 */
@Data
public class SaveMenuCommand {

    /**
     * 父菜单id
     */
    private String parentId;

    /**
     * 菜单类型
     */
    @NotBlank(message = "菜单类型不能为空")
    private String menuType;

    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 路由标题
     */
    private String routeName;

    /**
     * 路由路径
     */
    private String routePath;

    /**
     * 排序值
     */
    private Integer sortNumber;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    @NotBlank(message = "状态不能为空")
    private String status;


    public MenuDO to() {

        MenuDO menuDO = new MenuDO();
        menuDO.setParentId(this.getParentId());
        menuDO.setMenuType(this.getMenuType());
        menuDO.setName(this.getName());
        menuDO.setPath(this.getPath());
        menuDO.setRouteName(this.getRouteName());
        menuDO.setRoutePath(this.getRoutePath());
        menuDO.setSortNumber(this.getSortNumber());
        menuDO.setDescription(this.getDescription());
        menuDO.setStatus(this.getStatus());
        return menuDO;

    }

    public MenuDO update(MenuDO menuDO) {

        menuDO.setParentId(this.getParentId());
        menuDO.setMenuType(this.getMenuType());
        menuDO.setName(this.getName());
        menuDO.setPath(this.getPath());
        menuDO.setRouteName(this.getRouteName());
        menuDO.setRoutePath(this.getRoutePath());
        menuDO.setSortNumber(this.getSortNumber());
        menuDO.setDescription(this.getDescription());
        menuDO.setStatus(this.getStatus());
        return menuDO;
    }
}
