package com.smartsearchdocument.repo.dynamic;


import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.smartsearchdocument.common.Ex;
import com.smartsearchdocument.dto.query.RoleMenuPaging;
import com.smartsearchdocument.common.DOBase;
import com.smartsearchdocument.dos.RoleMenuDO;
import com.smartsearchdocument.util.QueryUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * 角色、菜单关联表DynamicDao
 *
 * @author NotEdibleSalt

 */
@Slf4j
@Repository
@AllArgsConstructor
public class RoleMenuDynamicDao {


    private final JdbcTemplate jdbcTemplate;


    public Page<RoleMenuDO> roleMenuPaging(RoleMenuPaging roleMenuPaging, Pageable pageable) {

        String sql = " select * from role_menu where not_del = true ";
        return QueryUtil.of(sql)
                        .dynamicAppendCondition(" and menu_id = ", roleMenuPaging.getMenuId())
                        .dynamicAppendCondition(" and role_id = ", roleMenuPaging.getRoleId())
                        .page(jdbcTemplate, pageable, RoleMenuDO.class);

    }
}
