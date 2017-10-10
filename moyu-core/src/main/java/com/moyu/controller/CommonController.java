package com.moyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XianGuo
 * Date: 2017-09-18 21:40
 */
@Controller
public class CommonController {

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/hello.html")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login.html")
    public String login(){
        return "login.html";
    }
}

