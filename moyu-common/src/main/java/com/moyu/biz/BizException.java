package com.moyu.biz;

/**
 * Created by XianGuo
 * Date: 2017-07-23 01:01
 * 异常
 */
public class BizException extends Exception {

    private String code;
    private String msg;

    public BizException() {
        super();
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
