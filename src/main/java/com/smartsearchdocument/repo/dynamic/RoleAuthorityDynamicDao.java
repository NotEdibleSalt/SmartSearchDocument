package com.smartsearchdocument.repo.dynamic;


import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dto.query.RoleAuthorityPaging;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.dos.RoleAuthorityDO;
import com.smartsearchdocument.util.QueryUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * 角色、权限关联表DynamicDao
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Repository
@AllArgsConstructor
public class RoleAuthorityDynamicDao {


    private final JdbcTemplate jdbcTemplate;


    public Page<RoleAuthorityDO> roleAuthorityPaging(RoleAuthorityPaging roleAuthorityPaging, Pageable pageable) {

        String sql = " select * from role_authority where not_del = true ";
        return QueryUtil.of(sql)
                        .dynamicAppendCondition(" and authority_id like ", roleAuthorityPaging.getAuthorityId())
                        .dynamicAppendCondition(" and role_id = ", roleAuthorityPaging.getRoleId())
                        .page(jdbcTemplate, pageable, RoleAuthorityDO.class);

    }
}
