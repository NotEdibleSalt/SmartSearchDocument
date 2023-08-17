package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.dos.RoleAuthorityDO;
import com.smartsearchdocument.repo.RoleAuthorityRepo;
import com.smartsearchdocument.service.RoleAuthorityService;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dto.command.SaveRoleAuthorityCommand;
import com.smartsearchdocument.dto.query.RoleAuthorityPaging;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.repo.dynamic.RoleAuthorityDynamicDao;

/**
 * 角色、权限关联表ServiceImpl
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

    private final RoleAuthorityRepo roleAuthorityRepo;
    private final RoleAuthorityDynamicDao roleAuthorityDynamicDao;

    @Override
    public RoleAuthorityDO addRoleAuthority(SaveRoleAuthorityCommand saveRoleAuthorityCommand) {

        roleAuthorityRepo.findByRoleIdAndAuthorityId(saveRoleAuthorityCommand.getRoleId(), saveRoleAuthorityCommand.getAuthorityId())
                         .filter(DOBase::getNotDel)
                         .ifPresent(roleAuthorityDO -> {
                             throw Ex.of("角色已有此权限");
                         });

        RoleAuthorityDO roleAuthorityDO = saveRoleAuthorityCommand.to();
        return roleAuthorityRepo.save(roleAuthorityDO);
    }

    @Override
    public RoleAuthorityDO updateRoleAuthority(String id, SaveRoleAuthorityCommand saveRoleAuthorityCommand) {

        RoleAuthorityDO roleAuthorityDO = getRoleAuthorityById(id);
        RoleAuthorityDO roleAuthorityDONew = saveRoleAuthorityCommand.update(roleAuthorityDO);
        return roleAuthorityRepo.save(roleAuthorityDONew);
    }


    @Override
    public RoleAuthorityDO getRoleAuthorityById(String id) {

        return roleAuthorityRepo.findById(id)
                                .filter(DOBase::getNotDel)
                                .orElseThrow(() -> Ex.of("数据不存在"));
    }


    @Override
    public Page<RoleAuthorityDO> roleAuthorityPaging(RoleAuthorityPaging roleAuthorityPaging, Pageable pageable) {

        return roleAuthorityDynamicDao.roleAuthorityPaging(roleAuthorityPaging, pageable);
    }

    @Override
    public void delRoleAuthority(String id) {

        RoleAuthorityDO roleAuthorityDO = getRoleAuthorityById(id);
        roleAuthorityDO.setNotDel(false);
        roleAuthorityRepo.save(roleAuthorityDO);
    }
}
