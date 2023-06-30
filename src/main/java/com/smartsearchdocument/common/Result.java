package com.smartsearchdocument.common;


import java.io.Serializable;
import lombok.Data;

/**
 * 响应结果
 *
 * @author NotEdibleSalt
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    private boolean success;


    private String msg;


    private Integer code;


    /**
     * 结果对象
     */
    private T result;

    public static <T> Result<T> success() {

        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMsg("操作成功");
        result.setCode(200);

        return result;
    }

    public static <T> Result<T> success(T data) {

        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setResult(data);

        return result;
    }

    public static <T> Result<T> success(T data, String message) {

        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMsg(message);
        result.setCode(200);
        result.setResult(data);

        return result;
    }

    public static <T> Result<T> successMsg(String message) {

        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg(message);

        return result;
    }

    public static <T> Result<T> error() {

        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMsg("操作失败");
        result.setCode(500);
        return result;
    }

    public static <T> Result<T> error(String msg) {

        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMsg(msg);
        result.setCode(500);
        return result;
    }

    public static <T> Result<T> error(Integer code, String msg) {

        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }


}
