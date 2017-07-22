package com.moyu.service;

import com.moyu.biz.BizResult;
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
    BizResult<Long> login(UserDO userDO);

    /**
     * 插入用户
     */
    BizResult<Long> insertUser(UserDO userDO);

    /**
     * 更新修改用户信息
     */
    BizResult<Long> updateUser(UserDO userDO);

    /**
     * 注册
     */
    BizResult<UserDO> register(UserDO userDO);

    /**
     * 根据条件查询用户信息
     */
    BizResult<UserDO> selectByQuery(UserDO userDO);

    /**
     * 校验用户信息
     */
    BizResult validUser(UserDO userDO);

}
