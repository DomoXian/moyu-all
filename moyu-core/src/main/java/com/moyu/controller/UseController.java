package com.moyu.controller;

import com.moyu.biz.BizException;
import com.moyu.biz.WebResult;
import com.moyu.common.annotation.NoAuth;
import com.moyu.enums.WebCodeEnum;
import com.moyu.utils.StringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XianGuo
 * Date: 2017-09-13 15:39
 * 用户相关
 */
@RestController
public class UseController {

    @NoAuth
    @GetMapping("/getUser.json")
    public Object getUser() {
        String s="";
        if(StringUtil.isEmpty(s)){
            throw new BizException(WebCodeEnum.EMPTY);
        }
        return WebResult.createSuccessResult("成功的结果");
    }
}
