package com.smartsearchdocument.repo.dynamic;

import com.smartsearchdocument.dos.RoleDO;
import com.smartsearchdocument.dto.query.RolePagingDTO;
import com.smartsearchdocument.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author NotEdibleSalt
 */
@Repository
public class RoleDynamicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Page<RoleDO> rolePaging(RolePagingDTO rolePagingDTO, Pageable pageable) {

        String sql = " select * from role where not_del = true ";
        return QueryUtil.of(sql)
                        .dynamicAppendLikeR(" and name like ", rolePagingDTO.getName())
                        .dynamicAppendCondition(" and status = ", rolePagingDTO.getStatus())
                        .page(jdbcTemplate, pageable, RoleDO.class);

    }
}
