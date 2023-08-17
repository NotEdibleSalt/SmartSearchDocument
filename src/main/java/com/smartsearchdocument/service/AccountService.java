package com.smartsearchdocument.service;

import cn.dev33.satoken.util.SaResult;
import com.smartsearchdocument.controller.ro.TreeDataRO;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.dto.command.SaveAccountCommand;
import com.smartsearchdocument.dto.query.AccountPaging;
import com.smartsearchdocument.dto.command.LoginDTO;
import java.util.List;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;


/**
 * 账户Service
 *
 * @author NotEdibleSalt
 */
@Validated
public interface AccountService {


    /**
     * 登录
     *
     * @param loginDTO 登录参数
     * @return java.lang.String
     * @author NotEdibleSalt
     */
    SaResult login(@Valid LoginDTO loginDTO);

    /**
     * 获取帐户菜单
     *
     * @param accountId 账号id
     * @return java.util.List<com.smartsearchdocument.controller.ro.TreeDataRO>
    
     * @author NotEdibleSalt
     */
    List<TreeDataRO> getAccountMenus(String accountId);

    /**
     * 添加账户
     *
     * @param saveAccountCommand 保存账户DTO
     * @return com.smartsearchdocument.dos.AccountDO
     * @author NotEdibleSalt
    
     */
    AccountDO addAccount(@Valid SaveAccountCommand saveAccountCommand);

    /**
     * 修改账户
     *
     * @param id                 id
     * @param saveAccountCommand 保存账户DTO
     * @return com.smartsearchdocument.dos.AccountDO
     * @author NotEdibleSalt
    
     */
    AccountDO updateAccount(String id, @Valid SaveAccountCommand saveAccountCommand);

    /**
     * 查询账户 通过id
     *
     * @param id 账户id
     * @return com.smartsearchdocument.dos.AccountDO
     * @author NotEdibleSalt
    
     */
    AccountDO getAccountById(String id);

    /**
     * 分页查询账户
     *
     * @param accountPaging 分页查询账户参数
     * @param pageable      分页查询参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.dos.AccountDO>
     * @author NotEdibleSalt
    
     */
    Page<AccountDO> accountPaging(AccountPaging accountPaging, Pageable pageable);

    /**
     * 删除账户
     *
     * @param id id
     * @author NotEdibleSalt
    
     */
    void delAccount(String id);
}
