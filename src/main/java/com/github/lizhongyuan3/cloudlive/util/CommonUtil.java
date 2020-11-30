package com.github.lizhongyuan3.cloudlive.util;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author lizhongyuan
 */
public class CommonUtil {

    private static final char SEPARATOR = '_';
    private static final String OBJECT_CLASS_NAME = "java.lang.object";

    public static Map<String, Object> object2MapWithUnderline(Object  obj) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Field> fieldList = new ArrayList<>() ;
            Class<?> tempClass = obj.getClass();
            while (tempClass !=null && !OBJECT_CLASS_NAME.equals(tempClass.getName().toLowerCase())) {
                fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
                tempClass = tempClass.getSuperclass();
            }
            for (Field field : fieldList) {
                field.setAccessible(true);
                String fieldName = field.getName();
                fieldName = toUnderlineName(fieldName);
                if (field.get(obj) == null) {
                    continue;
                }
                map.put(fieldName, String.valueOf(field.get(obj)));
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
