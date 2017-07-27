package com.moyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XianGuo
 * Date: 2017-07-23 11:33
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String helloWord(){
        return "hello word";
    }
}
