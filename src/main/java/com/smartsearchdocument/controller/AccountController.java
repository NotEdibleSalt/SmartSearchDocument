package com.smartsearchdocument.controller;

import cn.dev33.satoken.util.SaResult;
import com.smartsearchdocument.common.Constant;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.common.Result;
import com.smartsearchdocument.controller.ro.TreeDataRO;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.dto.command.SaveAccountCommand;
import com.smartsearchdocument.dto.query.AccountPaging;
import com.smartsearchdocument.dto.command.LoginDTO;
import com.smartsearchdocument.service.AccountService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户Controller
 *
 * @author NotEdibleSalt
 */

@Slf4j
@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    /**
     * 登录
     *
     * @param loginDTO 登录参数
     * @return com.smartsearchdocument.common.Result<cn.dev33.satoken.util.SaResult>
     * @author NotEdibleSalt
     */
    @PostMapping("login")
    public Result<Object> login(@RequestBody LoginDTO loginDTO) {

        SaResult saResult = accountService.login(loginDTO);
        if (saResult.getCode() != 200) {
            throw Ex.of(saResult.getMsg());
        }
        return Result.success(saResult.getData());
    }

    /**
     * 获取帐户菜单
     *
     * @param accountId 账号id
     * @return com.smartsearchdocument.common.Result<java.util.List < com.smartsearchdocument.controller.ro.TreeDataRO>>
    
     * @author NotEdibleSalt
     */
    @GetMapping("{accountId}/menuTrees")
    public Result<List<TreeDataRO>> getAccountMenus(@PathVariable("accountId")String accountId) {

        List<TreeDataRO> treeDataROList = accountService.getAccountMenus(accountId);
        return Result.success(treeDataROList);
    }


    /**
     * 添加账户
     *
     * @param saveAccountCommand 保存账户DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.AccountDO>
    
     * @author NotEdibleSalt
     */
    @PostMapping("")
    public Result<AccountDO> addAccount(@RequestBody SaveAccountCommand saveAccountCommand) {

        AccountDO accountDO = accountService.addAccount(saveAccountCommand);
        return Result.success(accountDO);
    }

    /**
     * 修改账户
     *
     * @param id id
     * @param saveAccountCommand 保存账户DTO
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.AccountDO>
    
     * @author NotEdibleSalt
     */
    @PutMapping("{id}")
    public Result<AccountDO> updateAccount(@PathVariable("id") String id, @RequestBody SaveAccountCommand saveAccountCommand) {

        AccountDO accountDO = accountService.updateAccount(id, saveAccountCommand);
        return Result.success(accountDO);
    }


    /**
     * 查询账户
     *
     * @param id 账户id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.AccountDO>
    
     * @author NotEdibleSalt
     */
    @GetMapping("{id}")
    public Result<AccountDO> getAccountById(@PathVariable("id") String id) {

        AccountDO accountDO = accountService.getAccountById(id);
        return Result.success(accountDO);
    }


    /**
     * 分页查询账户
     *
     * @param accountPaging 分页查询账户参数
     * @param pageable 分页查询参数
     * @return com.smartsearchdocument.common.Result<org.springframework.data.domain.Page<com.smartsearchdocument.dos.AccountDO>>
    
     * @author NotEdibleSalt
     */
    @GetMapping("")
    public  Result<Page<AccountDO>> accountPaging(AccountPaging accountPaging, Pageable pageable) {

        Page<AccountDO> page = accountService.accountPaging(accountPaging, pageable);
        return Result.success(page);
    }

    /**
     * 删除账户
     *
     * @param id id
     * @return com.smartsearchdocument.common.Result<com.smartsearchdocument.dos.Account>
    
     * @author NotEdibleSalt
     */
    @DeleteMapping("{id}")
    public Result<AccountDO> delAccount(@PathVariable("id") String id) {

        accountService.delAccount(id);
        return Result.successMsg(Constant.DEL_SUCCESS_MSG);
    }
}
