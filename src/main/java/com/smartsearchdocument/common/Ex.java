package com.smartsearchdocument.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 *
 * @author NotEdibleSalt
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Ex extends RuntimeException {

    private String msg;

    private Ex() {
        this.msg = "错误";
    }

    private Ex(String msg) {
        super(msg);
    }

    private Ex(RuntimeException exception, String msg) {
        super(msg, exception);
        this.msg = msg;
    }

    public static Ex of(String msg, Object... args) {
        for (Object arg : args) {
            msg = msg.replaceFirst("\\{}", arg.toString());
        }

        return new Ex(msg);
    }

    public static Ex of(RuntimeException exception, String msg, Object... args) {

        for (Object arg : args) {
            msg = msg.replaceFirst("\\{}", arg.toString());
        }

        return new Ex(exception, msg);
    }

}
