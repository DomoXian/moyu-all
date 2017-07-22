package com.moyu.controller;

import com.moyu.biz.BizResult;
import com.moyu.dal.model.UserDO;
import com.moyu.request.RegisterRequest;
import com.moyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by XianGuo
 * Date: 2017-07-23 02:07
 * 用户相关的
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 注册
     */
    @PostMapping("register.json")
    public BizResult register(@RequestBody RegisterRequest request) {
        BizResult<Long> bizResult = new BizResult<>();
        UserDO userDO = new UserDO();
        userDO.setLoginName(request.getLoginName());
        userDO.setLoginPwd(request.getLoginPwd());
        userDO.setSex(request.getSex());
        BizResult<UserDO> registerResult = userService.register(userDO);
        if (registerResult.isFail()) {
            bizResult.setSuccess(false);
            bizResult.setMessage("注册失败");
            return bizResult;
        }

        bizResult.setSuccess(true);
        bizResult.setMessage("注册成功");
        bizResult.setData(registerResult.getData().getUserId());
        return bizResult;
    }
}
