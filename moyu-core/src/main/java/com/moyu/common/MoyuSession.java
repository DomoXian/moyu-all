package com.moyu.common;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XianGuo
 * Date: 2017-09-13 19:53
 */
public class MoyuSession {

    /**
     * 是否登录
     */
    public static boolean isLogin() {
        // 取出 request的sessionId
        HttpServletRequest request = getRequest();
        StringBuilder sb = new StringBuilder();
        sb.append("客户主机IP").append(request.getRemoteAddr());
        sb.append("请求URL").append(request.getRequestURL());
        System.out.println(sb.toString());
        return false;
    }


    /**
     * 获取当前线程的HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new IllegalArgumentException("获取HttpServletRequest失败！");
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }
}
