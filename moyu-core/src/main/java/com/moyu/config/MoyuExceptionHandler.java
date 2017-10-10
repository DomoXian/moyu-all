package com.moyu.config;

import com.moyu.biz.BizException;
import com.moyu.biz.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XianGuo
 * Date: 2017-09-19 17:31
 */
@ControllerAdvice
@Slf4j
public class MoyuExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handlerException(Exception e) {
        log.warn("系统异常：", e);
        if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            return WebResult.createResult(bizException.getCode(), bizException.getDesc());
        }
        return WebResult.createErrorResult();

    }

}
