package com.moyu.enums;

/**
 * Created by XianGuo
 * Date: 2017-07-23 01:34
 */
public enum UserStatusEnum {
    NORMAL(0, "正常用户"),
    DELETE(-1, "删除用户"),
    BLACKLIST(1, "黑名单");
    private Integer code;
    private String desc;

    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserStatusEnum valueOf(Integer code) {
        if (code == null) {
            return BLACKLIST;
        }
        switch (code) {
            case 0:
                return NORMAL;
            case 1:
                return BLACKLIST;
            case -1:
                return DELETE;
            default:
                return BLACKLIST;
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
