package com.moyu.common.domain;

import lombok.Getter;

/**
 * Created by XianGuo
 * Date: 2017-07-06 19:47
 * 业务枚举类
 */
public enum BizErrorEnum {
    RESULT_OK("1001", "请求成功"),
    RESULR_EMPTY("1002", "数据为空");

    @Getter
    private String code;
    @Getter
    private String message;

    BizErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
