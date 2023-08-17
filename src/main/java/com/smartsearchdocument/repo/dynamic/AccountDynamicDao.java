package com.smartsearchdocument.repo.dynamic;


import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dto.query.AccountPaging;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.dos.AccountDO;
import com.smartsearchdocument.util.QueryUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * 账户DynamicDao
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Repository
@AllArgsConstructor
public class AccountDynamicDao {


    private final JdbcTemplate jdbcTemplate;


    public Page<AccountDO> accountPaging(AccountPaging accountPaging, Pageable pageable) {

        String sql = " select * from account where not_del = true ";
        return QueryUtil.of(sql)
                        .dynamicAppendLikeR(" and name like ", accountPaging.getName())
                        .dynamicAppendCondition(" and status = ", accountPaging.getStatus())
                        .page(jdbcTemplate, pageable, AccountDO.class);

    }
}
