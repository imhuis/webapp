package com.imhui.common.base;

import java.io.Serializable;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 638256389004127740L;

    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
