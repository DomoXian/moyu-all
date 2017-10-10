package com.moyu.enums;

import lombok.Getter;

/**
 * Created by XianGuo
 * Date: 2017-09-19 16:59
 */
public enum WebCodeEnum implements BaseEnum{
    SUCCESS(200,"请求成功"),
    EMPTY(204,"请求结果为空"),
    AUTH_FAIL(401,"session过期"),
    SEVER_ERROR(500,"服务器错误"),
    NOT_FOUND(404,"url找不到"),
    ;

    @Getter
    private Integer code;

    @Getter
    private String desc;

    WebCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
