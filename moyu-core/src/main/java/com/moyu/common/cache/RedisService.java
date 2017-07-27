package com.moyu.common.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by XianGuo
 * Date: 2017-07-23 12:37
 * redis 服务
 */
@Service
@SuppressWarnings("all")
public class RedisService {
    private static final String DEFAULT_ENCODE = "UTF-8";

    private final RedisTemplate redisTemplate;


    @Autowired
    public RedisService(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setValue(String key, Object value) {
        setValue(key, JSON.toJSONString(value));
    }

    public void setValue(String key, String json) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, json);
    }

    public <T> T getValue(String key, Class<T> cls) {
        String json = getValue(key);
        try {
            return JSON.parseObject(json, cls);
        } catch (Exception e) {
            return null;
        }
    }

    public String getValue(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }


}
