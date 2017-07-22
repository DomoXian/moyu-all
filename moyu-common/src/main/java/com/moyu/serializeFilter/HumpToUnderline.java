package com.moyu.serializeFilter;

import com.alibaba.fastjson.serializer.NameFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XianGuo
 * Date: 2017-07-12 17:43
 */
public class HumpToUnderline implements NameFilter {
    @Override
    public String process(Object o, String str, Object o1) {
        if (str == null || "".equals(str.trim())) return "";
        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "_" + g.toLowerCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

}
