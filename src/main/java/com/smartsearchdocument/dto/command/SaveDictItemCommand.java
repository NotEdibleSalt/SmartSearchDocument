package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.DictItemDO;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 字典项保存参数
 *
 * @author NotEdibleSalt

 */
@Data
public class SaveDictItemCommand {


    /**
     * 字典ID
     */
    @NotBlank(message = "字典ID不能为空")
    private String dictId;

    /**
     * 值
     */
    @NotBlank(message = "值不能为空")
    private String value;

    /**
     * 标签
     */
    @NotBlank(message = "标签不能为空")
    private String label;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private Integer sort;

    /**
     * 状态 ENABLE： 启用  DISABLE：禁用
     */
    @NotBlank(message = "状态不能为空")
    private String status;


    public DictItemDO to( ) {

        DictItemDO dictItemDO = new DictItemDO();
        dictItemDO.setDictId(this.getDictId());
        dictItemDO.setValue(this.getValue());
        dictItemDO.setLabel(this.getLabel());
        dictItemDO.setDescription(this.getDescription());
        dictItemDO.setSort(this.getSort());
        dictItemDO.setStatus(this.getStatus());
        return dictItemDO;

    }

    public DictItemDO update(DictItemDO dictItemDO) {

        dictItemDO.setDictId(dictItemDO.getDictId());
        dictItemDO.setValue(dictItemDO.getValue());
        dictItemDO.setLabel(dictItemDO.getLabel());
        dictItemDO.setDescription(dictItemDO.getDescription());
        dictItemDO.setSort(dictItemDO.getSort());
        dictItemDO.setStatus(dictItemDO.getStatus());
        return dictItemDO;

    }
}
