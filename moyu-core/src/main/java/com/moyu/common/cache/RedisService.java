package com.moyu.common.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by XianGuo
 * Date: 2017-07-23 12:37
 * redis 服务
 */
@Service
@SuppressWarnings("all")
public class RedisService {
    private static final String DEFAULT_ENCODE = "UTF-8";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 插入一个对象
     * 序列化成json字符串插入
     */
    public void setValue(String key, Object value) {
        setValue(key, JSON.toJSONString(value));
    }

    /**
     * 插入一个对象
     *
     * @param timeout 过期时间默认毫秒
     */
    public void setValue(String key, Object value, Long timeout) {
        this.setValue(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * 插入一个对象
     *
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     */
    public void setValue(String key, Object value, Long timeout, TimeUnit timeUnit) {
        this.setValue(key, JSON.toJSONString(value), timeout, timeUnit);
    }

    /**
     * 插入一个字符串
     */
    public void setValue(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * 插入的时候设置过期时间
     *
     * @param timeout 超时时间默认为毫秒
     */
    public void setValue(String key, String value, long timeout) {
        this.setValue(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    /**
     * 插入的时候设置过期时间
     */
    public void setValue(String key, String value, long timeout, TimeUnit timeUnit) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value, timeout, timeUnit);
    }

    /**
     * 通过key获取对象
     */
    public <T> T getValue(String key, Class<T> cls) {
        String json = getValue(key);
        try {
            return JSON.parseObject(json, cls);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过key获取字符串
     */
    public String getValue(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 删除key
     */
    public void deleteValue(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 删除多个key
     */
    public void deleteValue(List<String> key) {
        stringRedisTemplate.delete(key);
    }


}
