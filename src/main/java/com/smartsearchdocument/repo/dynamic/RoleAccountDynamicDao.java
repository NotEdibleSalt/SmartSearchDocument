package com.smartsearchdocument.repo.dynamic;


import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dto.query.RoleAccountPaging;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.dos.RoleAccountDO;
import com.smartsearchdocument.util.QueryUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * 角色、账号关联表DynamicDao
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Repository
@AllArgsConstructor
public class RoleAccountDynamicDao {


    private final JdbcTemplate jdbcTemplate;


    public Page<RoleAccountDO> roleAccountPaging(RoleAccountPaging roleAccountPaging, Pageable pageable) {

        String sql = " select * from role_account where not_del = true ";
        return QueryUtil.of(sql)
                        .dynamicAppendCondition(" and account_id like ", roleAccountPaging.getAccountId())
                        .dynamicAppendCondition(" and role_id = ", roleAccountPaging.getRoleId())
                        .page(jdbcTemplate, pageable, RoleAccountDO.class);

    }
}
