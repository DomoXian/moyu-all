package com.moyu.biz;

import com.moyu.enums.BaseEnum;
import com.moyu.enums.WebCodeEnum;
import lombok.Data;

/**
 * Created by XianGuo
 * Date: 2017-09-19 16:58
 * web结果封装
 */
@Data
@SuppressWarnings("all")
public class WebResult<T> {

    private Integer status;

    private String msg;

    private T data;

    public WebResult() {
        this(null, null);
    }

    public WebResult(Integer status, String msg) {
        this(status, msg, null);
    }

    public WebResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> WebResult<T> createResult(Integer status,String msg, T data) {
        return new WebResult<>(status, msg, data);
    }

    public static WebResult createResult(Integer status,String msg) {
        return createResult(status,msg,null);
    }

    public static <T> WebResult<T> createResult(BaseEnum codeEnum, T data) {
        return createResult(codeEnum.getCode(), codeEnum.getDesc(), data);
    }

    public static WebResult createResult(BaseEnum codeEnum) {
        return createResult(codeEnum, null);
    }

    public static <T> WebResult<T> createSuccessResult(T data) {
        return createResult(WebCodeEnum.SUCCESS, data);
    }

    public static WebResult createErrorResult() {
        return createResult(WebCodeEnum.SEVER_ERROR);
    }

}
