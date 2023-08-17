package com.smartsearchdocument.repo.dynamic;


import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dto.query.DictPaging;

import com.smartsearchdocument.dos.DictDO;
import com.smartsearchdocument.util.QueryUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * 字典表DynamicDao
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Repository
@AllArgsConstructor
public class DictDynamicDao {


    private final JdbcTemplate jdbcTemplate;


    public Page<DictDO> dictPaging(DictPaging dictPaging, Pageable pageable) {

        String sql = " select * from dict where not_del = true ";
        return QueryUtil.of(sql)
                        .dynamicAppendLikeR(" and name like ", dictPaging.getName())
                        .dynamicAppendCondition(" and status = ", dictPaging.getStatus())
                        .page(jdbcTemplate, pageable, DictDO.class);

    }
}
