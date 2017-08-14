package com.moyu;

import com.alibaba.fastjson.JSON;
import com.moyu.common.cache.RedisService;
import com.moyu.dal.model.UserDO;
import com.moyu.manager.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoyuCoreApplication.class)
public class MoyuCoreApplicationTests {

    @Autowired
    private UserManager userManager;

    @Autowired
    private RedisService redisService;

    @Test
    public void redisService(){
        UserDO userDO = userManager.selectByPrimaryKey(1L);
        System.out.println(JSON.toJSONString(userDO));
        redisService.setValue("user_info",userDO);

        UserDO userDO2 = redisService.getValue("user_info",UserDO.class);
        System.out.println(JSON.toJSONString(userDO2));

    }

}
