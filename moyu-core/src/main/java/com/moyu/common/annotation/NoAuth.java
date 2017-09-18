package com.moyu.common.annotation;


import java.lang.annotation.*;

/**
 * Created by XianGuo
 * Date: 2017-09-13 17:13
 * 不需要登录注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoAuth {
}
