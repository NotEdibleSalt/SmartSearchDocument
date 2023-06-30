package com.smartsearchdocument.service;

import cn.dev33.satoken.util.SaResult;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.dto.AccountPagingDTO;
import com.smartsearchdocument.dto.LoginDTO;
import com.smartsearchdocument.dto.RegisterAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * 账户Service
 *
 * @author NotEdibleSalt
 */
public interface AccountService {

    /**
     * 查询账户 通过id
     *
     * @param id 账户id
     * @return com.smartsearchdocument.entity.AccountDO
     * @author NotEdibleSalt
     */
    AccountDO getAccountById(String id);

    /**
     * 分页查询账户
     *
     * @param accountPagingDTO 分页查询账户参数
     * @param pageVo           分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.entity.AccountDO>
     * @author NotEdibleSalt
     */
    Page<AccountDO> accountPaging(AccountPagingDTO accountPagingDTO, Pageable pageVo);

    /**
     * 注册账号
     *
     * @param registerAccount 注册账号参数
     * @return com.smartsearchdocument.dos.AccountDO
     * @author NotEdibleSalt
     */
    AccountDO register(RegisterAccount registerAccount);

    /**
     * 登录
     *
     * @param loginDTO 登录参数
     * @return java.lang.String
     * @author NotEdibleSalt
     */
    SaResult login(LoginDTO loginDTO);
}
