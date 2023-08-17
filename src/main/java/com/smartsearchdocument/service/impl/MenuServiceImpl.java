package com.smartsearchdocument.service.impl;


import cn.hutool.core.util.StrUtil;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.controller.ro.TreeDataRO;
import com.smartsearchdocument.dos.MenuDO;
import com.smartsearchdocument.dto.command.SaveMenuCommand;
import com.smartsearchdocument.repo.MenuRepo;
import com.smartsearchdocument.service.MenuService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public MenuDO addMenu(SaveMenuCommand saveMenuCommand) {

        MenuDO menuDO = saveMenuCommand.to();
        return menuRepo.save(menuDO);
    }

    @Override
    public MenuDO updateMenu(String id, SaveMenuCommand saveMenuCommand) {

        MenuDO menuDO = getMenuById(id);
        MenuDO menuDONew = saveMenuCommand.update(menuDO);

        return menuRepo.save(menuDONew);
    }

    @Override
    public MenuDO getMenuById(String id) {

        return menuRepo.findById(id)
                       .filter(DOBase::getNotDel)
                       .map(menuDO -> {
                           if (StrUtil.isNotBlank(menuDO.getParentId())) {
                               MenuDO parentMenuDO = menuRepo.findById(menuDO.getParentId())
                                                             .orElseThrow(() -> Ex.of("上级菜单不存在"));
                               menuDO.setParentName(parentMenuDO.getName());
                           }
                           return menuDO;
                       })
                       .orElseThrow(() -> Ex.of("菜单不存在"));
    }

    @Override
    public void delMenu(String id) {

        MenuDO menuDO = getMenuById(id);
        menuDO.setNotDel(false);
        menuRepo.save(menuDO);
    }

    @Override
    public List<TreeDataRO> getMenuTree() {

        List<MenuDO> menuDOList = new ArrayList<>();
        menuRepo.findAll()
                .forEach(menuDO -> {
                    if (menuDO.getNotDel()) {
                        menuDOList.add(menuDO);
                    }
                });

        return TreeDataRO.from(menuDOList);
    }
}
