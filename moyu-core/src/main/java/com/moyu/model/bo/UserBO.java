package com.moyu.model.bo;

import java.util.Date;

/**
 * Created by XianGuo
 * Date: 2017-07-06 20:01
 * 用户信息
 */
public class UserBO {
    /**
     *
     * 用户id
     */
    private Long userId;

    /**
     *
     * 用户姓名
     */
    private String userName;

    /**
     *
     * 登录名称
     */
    private String loginName;

    /**
     *
     * 登录密码
     */
    private String loginPwd;

    /**
     *
     * 手机号码
     */
    private String userMobile;

    /**
     *
     * 用户状态
     */
    private Integer userStatus;

    /**
     *
     * 性别
     */
    private Integer sex;

    /**
     *
     * 出生日期
     */
    private java.sql.Date birthDate;

    /**
     *
     * 操作时间
     */
    private Date gmtModified;

    /**
     *
     * 创建时间
     */
    private Date gmtCreate;
}
