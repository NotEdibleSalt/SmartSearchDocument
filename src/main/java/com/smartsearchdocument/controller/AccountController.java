package com.smartsearchdocument.controller;

import cn.dev33.satoken.util.SaResult;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.dto.AccountPagingDTO;
import com.smartsearchdocument.dto.LoginDTO;
import com.smartsearchdocument.dto.RegisterAccount;
import com.smartsearchdocument.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户Controller
 *
 * @author NotEdibleSalt
 */

@Slf4j
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    /**
     * 查询账户
     *
     * @param id 账户id
     * @return cn.exrick.xboot.common.vo.Result<com.smartsearchdocument.entity.AccountDO>
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<AccountDO> getAccountById(@RequestParam("id") String id) {

        AccountDO accountDO = accountService.getAccountById(id);
        return Result.success(accountDO);
    }


    /**
     * 分页查询账户
     *
     * @param accountPagingDTO 分页查询账户参数
     * @param pageVo           分页查询参数
     * @return cn.exrick.xboot.common.vo.Result<org.springframework.data.domain.Page < com.smartsearchdocument.entity.Account>>
     * @author NotEdibleSalt
     */
    @GetMapping("")
    public Result<Page<AccountDO>> accountPaging(AccountPagingDTO accountPagingDTO, Pageable pageVo) {

        Page<AccountDO> page = accountService.accountPaging(accountPagingDTO, pageVo);
        return Result.success(page);
    }

    /**
     * 注册账号
     *
     * @param registerAccount 注册账号参数
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.AccountDO>
     * @author NotEdibleSalt
     */
    @PostMapping("register")
    public Result<AccountDO> register(@RequestBody RegisterAccount registerAccount) {

        AccountDO accountDO = accountService.register(registerAccount);
        return Result.success(accountDO);
    }

    /**
     * 登录
     *
     * @param loginDTO 登录参数
     * @return com.smartsearchdocument.common.Result<cn.dev33.satoken.util.SaResult>
     * @author NotEdibleSalt
     */
    @PostMapping("login")
    public Result<SaResult> login(@RequestBody LoginDTO loginDTO) {

        SaResult saResult = accountService.login(loginDTO);
        return Result.success(saResult);
    }

}
