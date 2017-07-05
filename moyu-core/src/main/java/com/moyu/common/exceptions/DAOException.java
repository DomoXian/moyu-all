package com.moyu.common.exceptions;

/**
 * Created by XianGuo
 * Date: 2017-07-05 20:23
 * 数据库操作异常
 */
public class DAOException extends Exception {

    private String code;
    private String msg;

    public DAOException() {
        super();
    }

    public DAOException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public DAOException(String code, String msg) {
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
