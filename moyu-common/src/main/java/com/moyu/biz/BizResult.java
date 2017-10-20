package com.moyu.biz;


import java.io.Serializable;

/**
 * Created by XianGuo
 * Date: 2017-07-06 19:42
 * 数据封装
 */
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

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (!this.isSuccess) {
            this.message = message;
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        if (data == null) {
            this.isSuccess = false;
            this.data = null;
        } else {
            this.message = "请求成功";
            this.isSuccess = true;
            this.data = data;
        }
    }
}
