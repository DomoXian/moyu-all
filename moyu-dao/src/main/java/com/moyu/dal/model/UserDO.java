package com.moyu.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     * user.user_id
     */
    private Long userId;

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

    /**
     * 
     * user.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * user.gmt_modified
     */
    private Date gmtModified;

}