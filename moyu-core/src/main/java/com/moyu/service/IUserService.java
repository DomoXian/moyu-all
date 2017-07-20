package com.moyu.service;

import com.moyu.common.domain.BizResult;
import com.moyu.dal.model.UserDO;
import com.moyu.model.form.UserForm;

/**
 * Created by XianGuo
 * Date: 2017-07-05 20:19
 */
public interface IUserService {
    /**
     * 登录
     */
    void login();

    void insertUser();

    void updateUser();

    /**
     * 注册
     */
    BizResult<UserDO> register(UserForm userForm);

}
