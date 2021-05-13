package com.imhui.common.enums;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
public enum ResponseCodeEnum {

    SUCCESS(0, "success");

    private final Integer code;
    private final String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }
}
