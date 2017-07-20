package com.moyu.service.serviceImpl;

import com.moyu.common.domain.BizResult;
import com.moyu.dal.mapper.UserMapper;
import com.moyu.dal.model.UserDO;
import com.moyu.dal.query.UserQuery;
import com.moyu.model.form.UserForm;
import com.moyu.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XianGuo
 * Date: 2017-07-05 21:09
 */
@Slf4j
@Service
public class TestServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void login() {

    }

    @Override
    public void insertUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public BizResult<UserDO> register(UserForm userForm) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userForm,userDO);
        userMapper.insertSelective(userDO);
        return null;
    }

}
