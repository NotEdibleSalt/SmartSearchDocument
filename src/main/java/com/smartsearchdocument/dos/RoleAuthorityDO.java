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
 * 角色、权限关联表DO
 *
 * @author NotEdibleSalt

 */

@Data
@Table("role_authority")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleAuthorityDO extends DOBase implements Serializable {


    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String authorityId;


}
