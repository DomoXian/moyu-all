package com.moyu.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * user.user_id
     */
    private Long userId;

    /**
     * 姓名
     * user.user_name
     */
    private String userName;

    /**
     * 登录名
     * user.login_name
     */
    private String loginName;

    /**
     * 密码
     * user.login_pwd
     */
    private String loginPwd;

    /**
     * 手机号
     * user.user_mobile
     */
    private String userMobile;

    /**
     * 用户状态 0 正常 -1 删除 1 黑名单
     * user.user_status
     */
    private Integer userStatus;

    /**
     * 性别 0未知 1男 2女
     * user.sex
     */
    private Integer sex;

    /**
     * 出生日期 1997-02-21
     * user.birth_date
     */
    private java.sql.Date birthDate;

    /**
     * 操作时间
     * user.gmt_modified
     */
    private Date gmtModified;

    /**
     * 创建时间
     * user.gmt_create
     */
    private Date gmtCreate;

}