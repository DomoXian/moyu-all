package com.moyu;

import redis.clients.jedis.Jedis;

/**
 * Created by XianGuo
 * Date: 2017-07-23 21:40
 */
public class Test {

    public static void main(String[] args) {
        String host = "106.14.144.168";
        int port = 6379;
        String password = "r-uf641dc75a974ed4:Alix123456";
        Jedis jedis = new Jedis(host, port);
        jedis.auth(password);

        System.out.println(jedis.ping());
    }
}
