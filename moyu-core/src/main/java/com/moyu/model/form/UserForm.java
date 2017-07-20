package com.moyu.model.form;

import lombok.Data;

/**
 * Created by XianGuo
 * Date: 2017-07-06 20:08
 */
@Data
public class UserForm {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 用户状态 0 正常 -1 删除
     */
    private Integer userStatus;
}
