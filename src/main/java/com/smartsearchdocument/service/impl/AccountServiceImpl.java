package com.smartsearchdocument.service.impl;


import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.dto.AccountPagingDTO;
import com.smartsearchdocument.dto.LoginDTO;
import com.smartsearchdocument.dto.RegisterAccount;
import com.smartsearchdocument.repo.AccountRepo;
import com.smartsearchdocument.service.AccountService;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;


    @Override
    public AccountDO getAccountById(String id) {

        return accountRepo.findById(id)
                          .orElseThrow(() -> Ex.of("账户不存在"));
    }


    @Override
    public Page<AccountDO> accountPaging(AccountPagingDTO accountPagingDTO, Pageable pageVo) {

        return null;
    }

    @Override
    public AccountDO register(RegisterAccount registerAccount) {

        boolean equals = Objects.equals(registerAccount.getPassword(), registerAccount.getConfirmPassword());
        if (!equals) {
            throw Ex.of("密码和确认密码不一致");
        }

        boolean present = accountRepo.findByUsername(registerAccount.getUsername())
                                     .isPresent();
        if (present) {
            throw Ex.of("用户已存在");
        }

        String password = BCrypt.hashpw(registerAccount.getPassword(), BCrypt.gensalt());
        registerAccount.setPassword(password);
        AccountDO accountDO = registerAccount.to();

        return accountRepo.save(accountDO);
    }

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
}
