package com.moyu.biz;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by XianGuo
 * Date: 2017-07-06 19:42
 * 数据封装
 */
@Data
@SuppressWarnings("all")
public class BizResult<T> implements Serializable {

    private boolean isSuccess;
    private String code;
    private String message;
    private T data;

    public static <T> BizResult<T> createResult(BizErrorEnum errorEnum) {
        BizResult<T> result = new BizResult<>();
        result.setSuccess(errorEnum == BizErrorEnum.RESULT_OK);
        result.setCode(errorEnum.getCode());
        result.setMessage(errorEnum.getMessage());
        return result;
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFail() {
        return !isSuccess;
    }
}
