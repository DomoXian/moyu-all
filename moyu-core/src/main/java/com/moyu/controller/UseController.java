package com.moyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XianGuo
 * Date: 2017-09-13 15:39
 * 用户相关
 */
@RestController
public class UseController {

    @GetMapping("/getUser.json")
    public String getUser() {

        return "测试";
    }
}
