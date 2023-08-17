package com.smartsearchdocument.dos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import com.smartsearchdocument.common.DOBase;

/**
 * 角色、账号关联表DO
 *
 * @author NotEdibleSalt

 */

@Data
@Table("role_account")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleAccountDO extends DOBase implements Serializable {


    /**
     * 管理员id
     */
    private String accountId;

    /**
     * 角色id
     */
    private String roleId;


}
