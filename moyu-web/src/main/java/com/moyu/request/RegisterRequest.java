package com.moyu.request;

import lombok.Data;

/**
 * Created by XianGuo
 * Date: 2017-07-23 02:24
 * 注册请求
 */
@Data
public class RegisterRequest {
    private String loginName;
    private String loginPwd;
    private int sex;

}
