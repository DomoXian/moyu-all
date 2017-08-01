package com.moyu;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * Created by XianGuo
 * Date: 2017-07-23 21:40
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
//        String host = "106.14.144.168";
//        int port = 6379;
//        String password = "r-uf641dc75a974ed4:Alix123456";
//        Jedis jedis = new Jedis(host, port);
//        jedis.auth(password);
//
//        System.out.println(jedis.ping());
        log.error("------------测试log-------------\n 换行测试");
        System.out.println(Integer.valueOf(String.valueOf("")));
    }
}
