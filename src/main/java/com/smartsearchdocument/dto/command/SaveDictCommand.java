package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.DictDO;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SaveDictCommand {
                        
                                                     
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
    private String system;
                                                         
    /**
    * 状态 ENABLE： 启用  DISABLE：禁用
    */
    private String status;
                                                         
    /**
    * 未删除
    */
    private Integer notDel;
                                        
                                    
                                    
                                    
            
    public DictDO to( ) {

        DictDO dictDO = new DictDO();
        dictDO.setName(this.getName());
        dictDO.setType(this.getType());
        dictDO.setRemark(this.getRemark());
        dictDO.setSystem(this.getSystem());
        dictDO.setStatus(this.getStatus());

        return dictDO;


    }

    public DictDO update(DictDO dictDO) {

        dictDO.setName(dictDO.getName());
        dictDO.setType(dictDO.getType());
        dictDO.setRemark(dictDO.getRemark());
        dictDO.setSystem(dictDO.getSystem());
        dictDO.setStatus(dictDO.getStatus());
        return dictDO;
    }
}
