package com.moyu.config;


import com.moyu.common.MoyuSession;
import com.moyu.common.annotation.NoAuth;
import com.moyu.utils.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by XianGuo
 * Date: 2017-09-13 16:31
 * 拦截器
 */
@Slf4j
public class MoyuInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod  = (HandlerMethod) handler;
        NoAuth noAuth = handlerMethod.getMethodAnnotation(NoAuth.class);

        if(noAuth !=null){
            return true;
        }

        if(MoyuSession.isLogin()){

        }else{
            log.info("跳转到登录页"+request.getContextPath());
//            response.sendRedirect(request.getContextPath()+"/login.html");
        }


        // TODO: 13/9/17 需要登录
        log.info("request：{}", JSONUtil.toJSONString(request.getRequestedSessionId()));

        return super.preHandle(request, response, handler);
    }
}
