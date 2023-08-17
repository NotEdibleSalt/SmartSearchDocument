package com.smartsearchdocument.service.impl;


import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.RoleAccountDO;
import com.smartsearchdocument.dto.command.SaveRoleAccountCommand;
import com.smartsearchdocument.dto.query.RoleAccountPaging;
import com.smartsearchdocument.repo.RoleAccountRepo;
import com.smartsearchdocument.repo.dynamic.RoleAccountDynamicDao;
import com.smartsearchdocument.service.RoleAccountService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色、账号关联表ServiceImpl
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class RoleAccountServiceImpl implements RoleAccountService {

    private final RoleAccountRepo roleAccountRepo;
    private final RoleAccountDynamicDao roleAccountDynamicDao;

    @Override
    public RoleAccountDO addRoleAccount(SaveRoleAccountCommand saveRoleAccountCommand) {

        roleAccountRepo.findByRoleIdAndAccountId(saveRoleAccountCommand.getRoleId(), saveRoleAccountCommand.getAccountId())
                       .stream()
                       .filter(DOBase::getNotDel)
                       .findAny()
                       .ifPresent(roleAccountDO -> {
                           throw Ex.of("账号已有该角色");
                       });

        RoleAccountDO roleAccountDO = saveRoleAccountCommand.to();
        return roleAccountRepo.save(roleAccountDO);
    }

    @Override
    public RoleAccountDO updateRoleAccount(String id, SaveRoleAccountCommand saveRoleAccountCommand) {

        roleAccountRepo.findByRoleIdAndAccountId(saveRoleAccountCommand.getRoleId(), saveRoleAccountCommand.getAccountId())
                       .stream()
                       .filter(DOBase::getNotDel)
                       .findAny()
                       .ifPresent(roleAccountDO -> {
                           throw Ex.of("账号已有该角色");
                       });

        RoleAccountDO roleAccountDO = getRoleAccountById(id);
        RoleAccountDO roleAccountDONew = saveRoleAccountCommand.update(roleAccountDO);
        return roleAccountRepo.save(roleAccountDONew);
    }


    @Override
    public RoleAccountDO getRoleAccountById(String id) {

        return roleAccountRepo.findById(id)
                              .filter(DOBase::getNotDel)
                              .orElseThrow(() -> Ex.of("数据不存在"));
    }


    @Override
    public Page<RoleAccountDO> roleAccountPaging(RoleAccountPaging roleAccountPaging, Pageable pageable) {

        return roleAccountDynamicDao.roleAccountPaging(roleAccountPaging, pageable);
    }

    @Override
    public void delRoleAccount(String id) {

        RoleAccountDO roleAccountDO = getRoleAccountById(id);
        roleAccountDO.setNotDel(false);
        roleAccountRepo.save(roleAccountDO);
    }

    @Override
    public List<RoleAccountDO> getRoleAccountsByAccountId(String accountId) {

        return roleAccountRepo.findByAccountId(accountId)
                              .stream()
                              .filter(DOBase::getNotDel)
                              .collect(Collectors.toList());
    }
}
