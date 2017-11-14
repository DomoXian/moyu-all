package com.moyu.api;

import com.domo.biz.BizResult;
import com.moyu.entity.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by XianGuo
 * Date: 2017-10-23 16:43
 */
@FeignClient("moyu")
public interface UserService {

    @PostMapping("/user/getUserInfo.json")
    BizResult<UserDTO> getUserInfo(@RequestParam Long userId);

}
