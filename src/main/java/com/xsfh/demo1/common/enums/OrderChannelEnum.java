package com.xsfh.demo1.common.enums;

public enum OrderChannelEnum {
    MEITUAN(1,"美团"),
    ELM(2,"饿了么"),
    OFFLINE(3,"线下购买");

    private int code;
    private String name;

    OrderChannelEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
