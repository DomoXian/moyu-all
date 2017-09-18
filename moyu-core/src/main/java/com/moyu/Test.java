package com.moyu;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XianGuo
 * Date: 2017-07-23 21:40
 */
@Slf4j
public class Test {

    public static void main(String[] args) {

        new Test().String();
//        String host = "106.14.144.168";
//        int port = 6379;
//        String password = "r-uf641dc75a974ed4:Alix123456";
//        Jedis jedis = new Jedis(host, port);
//        jedis.auth(password);
//
//        System.out.println(jedis.ping());
//        log.error("------------测试log-------------\n 换行测试");
    }

    public void String() {

        Gson gson = new Gson();
        List<Per> list = new ArrayList<>();
        Per p1 = new Per();
        p1.str = "ce";
        list.add(p1);
        list.add(p1);
        String json = gson.toJson(list);

        List<Per> object = gson.fromJson(json, List.class);
        System.out.println(JSON.toJSONString(object));
    }


    public static class Per {
        public String str;
    }
}
