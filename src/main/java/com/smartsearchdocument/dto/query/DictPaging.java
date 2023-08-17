package com.smartsearchdocument.dto.query;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DictPaging {
                        
                                                     
    /**
    * 名称
    */
    private String name;
                                                         
    /**
    * 类型
    */
    private String type;
                                                         
    /**
    * 备注
    */
    private String remark;
                                                         
    /**
    * 是否系统内置
    */
    private Integer system;
                                                         
    /**
    * 状态 ENABLE： 启用  DISABLE：禁用
    */
    private String status;
                                                         
    /**
    * 未删除
    */
    private Integer notDel;
                                        
                                    
                                    
                                    
            }
