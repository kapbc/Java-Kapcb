package com.kapcb.ccc.java.reflect.tdd;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: ReflectForResultMap </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28-16:09
 */
public class ReflectForResultMap {

   

    private static String parseSetMethodName(String fieldName) {
        if (fieldName == null || "".equals(fieldName)) {
            return null;
        }
        StringBuilder set = new StringBuilder("set");
        set.append(Character.toUpperCase(fieldName.charAt(0)));
        set.append(fieldName.substring(1));
        return set.toString();
    }
}
