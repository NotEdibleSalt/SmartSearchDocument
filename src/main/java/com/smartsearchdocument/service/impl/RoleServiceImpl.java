package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.RoleDO;
import com.smartsearchdocument.dto.query.RolePagingDTO;
import com.smartsearchdocument.dto.command.SaveRoleCommand;
import com.smartsearchdocument.repo.RoleRepo;
import com.smartsearchdocument.repo.dynamic.RoleDynamicDao;
import com.smartsearchdocument.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色表ServiceImpl
 *

 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;
    private final RoleDynamicDao roleDynamicDao;

    @Override
    public RoleDO addRole(SaveRoleCommand saveRoleCommand) {

        roleRepo.findByName(saveRoleCommand.getName())
                .filter(DOBase::getNotDel)
                .ifPresent(roleDO -> {
                    throw Ex.of("角色名已存在");
                });

        RoleDO roleDO = saveRoleCommand.to();
        return roleRepo.save(roleDO);
    }

    @Override
    public RoleDO updateRole(String id, SaveRoleCommand saveRoleCommand) {

        RoleDO roleDO = getRoleById(id);
        RoleDO roleDONew = saveRoleCommand.update(roleDO);
        return roleRepo.save(roleDONew);
    }

    @Override
    public RoleDO getRoleById(String id) {

        return roleRepo.findById(id)
                       .filter(DOBase::getNotDel)
                       .orElseThrow(() -> Ex.of("角色表不存在"));
    }


    @Override
    public Page<RoleDO> rolePaging(RolePagingDTO rolePagingDTO, Pageable pageable) {

        return roleDynamicDao.rolePaging(rolePagingDTO, pageable);
    }

    @Override
    public void delRole(String id) {

        RoleDO roleDO = getRoleById(id);
        roleDO.setNotDel(false);
        roleRepo.save(roleDO);
    }
}
