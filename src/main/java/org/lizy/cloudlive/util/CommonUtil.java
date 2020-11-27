package org.lizy.cloudlive.util;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author lizhongyuan
 */
public class CommonUtil {

    private static final char SEPARATOR = '_';

    public static Map<String, Object> object2MapWithUnderline(Object  obj) {
        Map<String, Object> map = new HashMap<>();
        try {
            Class<?> clazz = obj.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                fieldName = toUnderlineName(fieldName);
                String value = field.get(obj) == null ? "" : String.valueOf(field.get(obj));
                map.put(fieldName, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private static String toUnderlineName(String s) {
        if (null == s) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean nextUpperCase = true;
            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }
            if (Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    if (i > 0) {
                        sb.append(SEPARATOR);
                    }
                }
                upperCase = true;
            } else {
                upperCase = false;
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    public static String bjSign(Map<String, Object> params, String partnerKey) {
        TreeMap<String, Object> sortedMap = new TreeMap<>(params);
        StringBuilder toSign = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            String value = params.get(key).toString();
            if (StrUtil.isNotEmpty(value) && !"sign".equals(key) && !"key".equals(key)) {
                toSign.append(key).append("=").append(value).append("&");
            }
        }
        toSign.append("partner_key=").append(partnerKey);
        return DigestUtils.md5Hex(toSign.toString()).toLowerCase();
    }
}
