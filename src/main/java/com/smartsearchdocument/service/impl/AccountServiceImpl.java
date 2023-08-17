package com.smartsearchdocument.service.impl;


import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.controller.ro.TreeDataRO;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.dos.MenuDO;
import com.smartsearchdocument.dos.RoleMenuDO;
import com.smartsearchdocument.dto.command.LoginDTO;
import com.smartsearchdocument.dto.command.SaveAccountCommand;
import com.smartsearchdocument.dto.query.AccountPaging;
import com.smartsearchdocument.repo.AccountRepo;
import com.smartsearchdocument.repo.dynamic.AccountDynamicDao;
import com.smartsearchdocument.service.AccountService;
import com.smartsearchdocument.service.MenuService;
import com.smartsearchdocument.service.RoleAccountService;
import com.smartsearchdocument.service.RoleMenuService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户ServiceImpl
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final RoleAccountService roleAccountService;
    private final RoleMenuService roleMenuService;
    private final MenuService menuService;
    private final AccountDynamicDao accountDynamicDao;


    @Override
    public SaResult login(LoginDTO loginDTO) {

        AccountDO accountDO = accountRepo.findByUsername(loginDTO.getUsername())
                                         .orElseThrow(() -> Ex.of("账号不存在"));

        boolean checkpw = BCrypt.checkpw(loginDTO.getPassword(), accountDO.getPassword());
        if (checkpw) {
            StpUtil.login(accountDO.getId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return SaResult.data(tokenInfo);
        }

        throw Ex.of("密码错误, 请重新输入");
    }

    @Override
    public List<TreeDataRO> getAccountMenus(String accountId) {

        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        String loginId = (String) tokenInfo.getLoginId();
        AccountDO accountDO = getAccountById(loginId);

        if (!Objects.equals(accountId, loginId) && !accountDO.getUsername()
                                                             .equals("admin")) {
            throw Ex.of("没有获取此菜单的权限");
        }

        List<MenuDO> menuDOList = roleAccountService.getRoleAccountsByAccountId(accountId)
                                                    .stream()
                                                    .flatMap(roleAccountDO -> roleMenuService.getRoleMenusByRoleId(roleAccountDO.getRoleId())
                                                                                             .stream())
                                                    .map(RoleMenuDO::getMenuId)
                                                    .distinct()
                                                    .map(menuService::getMenuById)
                                                    .distinct()
                                                    .collect(Collectors.toList());

        return TreeDataRO.from(menuDOList);

    }

    @Override
    public AccountDO addAccount(SaveAccountCommand saveAccountCommand) {


        boolean present = accountRepo.findByUsername(saveAccountCommand.getUsername())
                                     .isPresent();
        if (present) {
            throw Ex.of("用户已存在");
        }

        String password = BCrypt.hashpw(saveAccountCommand.getPassword(), BCrypt.gensalt());
        saveAccountCommand.setPassword(password);
        AccountDO accountDO = saveAccountCommand.to();

        return accountRepo.save(accountDO);

    }

    @Override
    public AccountDO updateAccount(String id, SaveAccountCommand saveAccountCommand) {

        AccountDO accountDO = getAccountById(id);
        AccountDO accountDONew = saveAccountCommand.update(accountDO);
        return accountRepo.save(accountDONew);
    }


    @Override
    public AccountDO getAccountById(String id) {

        return accountRepo.findById(id)
                          .filter(DOBase::getNotDel)
                          .orElseThrow(() -> Ex.of("账户不存在"));
    }


    @Override
    public Page<AccountDO> accountPaging(AccountPaging accountPaging, Pageable pageable) {

        return accountDynamicDao.accountPaging(accountPaging, pageable);
    }

    @Override
    public void delAccount(String id) {

        AccountDO accountDO = getAccountById(id);
        accountDO.setNotDel(false);
        accountRepo.save(accountDO);
    }
}
