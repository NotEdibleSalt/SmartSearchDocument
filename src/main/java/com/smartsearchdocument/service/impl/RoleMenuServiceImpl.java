package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.RoleMenuDO;
import com.smartsearchdocument.dto.command.SaveRoleMenuCommand;
import com.smartsearchdocument.dto.query.RoleMenuPaging;
import com.smartsearchdocument.repo.RoleMenuRepo;
import com.smartsearchdocument.repo.dynamic.RoleMenuDynamicDao;
import com.smartsearchdocument.service.RoleMenuService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色、菜单关联表ServiceImpl
 *
 * @author NotEdibleSalt
RoleMenu
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuRepo roleMenuRepo;
    private final RoleMenuDynamicDao roleMenuDynamicDao;

    @Override
    public void addRoleMenu(SaveRoleMenuCommand saveRoleMenuCommand) {

        List<RoleMenuDO> roleMenuDOList = saveRoleMenuCommand.to()
                                                             .stream()
                                                             .peek(roleMenuDO -> {
                                                                 roleMenuRepo.findByRoleIdAndMenuId(saveRoleMenuCommand.getRoleId(), roleMenuDO.getMenuId())
                                                                             .stream()
                                                                             .filter(DOBase::getNotDel)
                                                                             .findAny()
                                                                             .ifPresent(r -> {
                                                                                 throw Ex.of("角色存在该菜单");
                                                                             });
                                                             })
                                                             .collect(Collectors.toList());
        roleMenuRepo.saveAll(roleMenuDOList);
    }



    @Override
    public RoleMenuDO getRoleMenuById(String id) {

        return roleMenuRepo.findById(id)
                           .filter(DOBase::getNotDel)
                           .orElseThrow(() -> Ex.of("数据不存在"));
    }


    @Override
    public Page<RoleMenuDO> roleMenuPaging(RoleMenuPaging roleMenuPaging, Pageable pageable) {

        return roleMenuDynamicDao.roleMenuPaging(roleMenuPaging, pageable);
    }

    @Override
    public void delRoleMenu(String id) {

        RoleMenuDO roleMenuDO = getRoleMenuById(id);
        roleMenuDO.setNotDel(false);
        roleMenuRepo.save(roleMenuDO);
    }

    @Override
    public List<RoleMenuDO> getRoleMenusByRoleId(String roleId) {

        return roleMenuRepo.findByRoleId(roleId)
                           .stream()
                           .filter(DOBase::getNotDel)
                           .collect(Collectors.toList());
    }
}
