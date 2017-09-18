package com.moyu.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by XianGuo
 * Date: 2017-09-12 10:49
 * 集合工具类
 */
public class CollectionUtil {

    /**
     * 判断集合是否为空
     *
     * @param c 集合
     */
    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    /**
     * 判断集合是否为空
     *
     * @param c 集合
     */
    public static boolean isNotEmpty(Collection<?> c) {
        return !isEmpty(c);
    }

    /**
     * 判断map 是否为空
     *
     * @param map 图
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 判断map 是否为空
     *
     * @param map 图
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

}
