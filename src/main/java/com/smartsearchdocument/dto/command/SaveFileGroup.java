package com.smartsearchdocument.dto.command;

import com.smartsearchdocument.dos.FileGroupDO;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 保存文件分组参数
 */
@Data
public class SaveFileGroup {

    /**
     * 分组名
     */
    @NotBlank(message = "请填写分组名")
    private String name;

    /**
     * 排序号
     */
    @NotBlank(message = "请填写排序号")
    private Integer sort;

    public FileGroupDO to() {

        FileGroupDO fileGroupDO = new FileGroupDO();
        fileGroupDO.setName(this.getName());
        fileGroupDO.setSort(this.getSort());
        return fileGroupDO;
    }
}
