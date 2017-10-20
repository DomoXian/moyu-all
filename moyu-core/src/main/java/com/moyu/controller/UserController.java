package com.moyu.controller;

import com.moyu.biz.BizErrorEnum;
import com.moyu.biz.BizResult;
import com.moyu.dal.model.UserDO;
import com.moyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by XianGuo
 * Date: 2017-10-20 17:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @PostMapping("/getUserInfo.json")
    public BizResult<UserDO> getUserInfo(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/queryUserInfo.json")
    public BizResult<List<UserDO>> queryUserInfo(@RequestBody UserDO userDO) {
        return BizResult.createResult(BizErrorEnum.RESULT_EMPTY);
    }
}
