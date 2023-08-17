package com.smartsearchdocument.repo.dynamic;

import cn.dev33.satoken.stp.StpUtil;
import com.smartsearchdocument.dos.FileDO;
import com.smartsearchdocument.dto.query.FilePagingDTO;
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
public class FileDynamicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 分页查询文件
     *
     * @param filePagingDTO 分页查询文件参数
     * @param pageable      分页参数
     * @return org.springframework.data.domain.Page<com.smartsearchdocument.dos.FileDO>
     * @author NotEdibleSalt
     */
    public Page<FileDO> filePaging(FilePagingDTO filePagingDTO, Pageable pageable) {

        String sql = "select * from file where not_del = true and create_by = ?";
        return QueryUtil.of(sql)
                        .dynamicAppendCondition(" and group_id = ", filePagingDTO.getGroupId())
                        .dynamicAppendLikeR(" and  file_name like ", filePagingDTO.getFileName())
                        .page(jdbcTemplate, new Object[]{StpUtil.getLoginId()}, pageable, FileDO.class);
    }

}
