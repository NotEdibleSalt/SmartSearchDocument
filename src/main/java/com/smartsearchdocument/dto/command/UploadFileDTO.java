package com.smartsearchdocument.dto.command;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 上传文件参数
 *
 * @author NotEdibleSalt
 */
@Data
public class UploadFileDTO {

    /**
     * 分组id
     */
    private String groupId;

    /**
     * 文件名
     */
    @NotBlank(message = "文件名不能为空")
    private String fileName;

    /**
     * 备注
     */
    private String remark;


}
