package com.moyu.enums;

/**
 * Created by XianGuo
 * Date: 2017-07-23 00:53
 * 性别枚举类
 */
public enum SexEnum {

    UNKNOWN(0, "未知性别"),
    MALE(1, "男"),
    FEMALE(2, "女");

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    SexEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SexEnum valueOf(Integer code) {
        if (code == null) {
            return UNKNOWN;
        }
        switch (code) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return UNKNOWN;
        }
    }
}
