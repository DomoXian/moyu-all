package com.moyu.config;

import com.moyu.biz.WebResult;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XianGuo
 * Date: 2017-09-19 16:55
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MoyuErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @ResponseBody
    @RequestMapping
    public Object doHandlerError(){
        return WebResult.createErrorResult();
    }

}
