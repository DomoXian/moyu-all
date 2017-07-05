package com.moyu.common.exceptions;

/**
 * Created by XianGuo
 * Date: 2017-07-05 20:40
 * 业务异常基类
 */
public class ServiceException extends Exception {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }
}
