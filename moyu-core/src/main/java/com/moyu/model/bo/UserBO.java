package com.moyu.model.bo;

/**
 * Created by XianGuo
 * Date: 2017-07-06 20:01
 * 用户信息
 */
public class UserBO {
    /**
     * 用户id
     * user.user_id
     */
    private Integer userId;

    /**
     * 登录名
     * user.login_name
     */
    private String loginName;

    /**
     * 登录密码
     * user.login_pwd
     */
    private String loginPwd;

    /**
     * 用户状态 0 正常 -1 删除
     * user.user_status
     */
    private Integer userStatus;
}
