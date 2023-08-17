package com.smartsearchdocument.controller.ro;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.MenuDO;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * @author NotEdibleSalt
 */
@Data
public class TreeDataRO {

    public TreeDataRO(MenuDO menuDO) {
        if (Objects.isNull(menuDO)) {
            throw Ex.of("暂无该菜单");
        }
        this.id = menuDO.getId();
        this.label = menuDO.getName();
        this.path = menuDO.getPath();
        this.routeName = menuDO.getRouteName();
        this.routePath = menuDO.getRoutePath();
    }

    private String id;

    private String label;

    private String path;

    private String routeName;

    private String routePath;

    private List<TreeDataRO> children;

    public static List<TreeDataRO> from(List<MenuDO> menuDOList) {

        Map<String, List<MenuDO>> menuDOGroup = menuDOList.stream()
                                                          .filter(menuDO -> StrUtil.isNotBlank(menuDO.getParentId()))
                                                          .collect(Collectors.groupingBy(MenuDO::getParentId));

        return menuDOList
            .stream()
            .filter(menuDO -> !menuDOGroup.containsKey(menuDO.getParentId()))
            .sorted(Comparator.comparing(MenuDO::getSortNumber))
            .map(TreeDataRO::new)
            .map(treeDataRO -> spanningTree(treeDataRO, menuDOGroup))
            .collect(Collectors.toList());

    }

    public static TreeDataRO spanningTree(TreeDataRO treeDataRO, Map<String, List<MenuDO>> menuDOGroup) {

        List<MenuDO> menuDOList = menuDOGroup.get(treeDataRO.getId());
        if (ObjectUtil.isEmpty(menuDOList)) {
            return treeDataRO;
        }

        List<TreeDataRO> treeDataROS = menuDOList
            .stream()
            .sorted(Comparator.comparing(MenuDO::getSortNumber))
            .map(TreeDataRO::new)
            .map(menuDO -> spanningTree(menuDO, menuDOGroup))
            .collect(Collectors.toList());

        treeDataRO.setChildren(treeDataROS);

        return treeDataRO;
    }

}
