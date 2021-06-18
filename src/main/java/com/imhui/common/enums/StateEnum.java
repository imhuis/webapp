package com.imhui.common.enums;

import java.util.Arrays;

public enum StateEnum implements IntArrayValuable {

    CREATED(1,"created"),
    WAITING(2, "waiting");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(StateEnum::getCode).toArray();

    private final Integer code;
    private final String name;

    StateEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
