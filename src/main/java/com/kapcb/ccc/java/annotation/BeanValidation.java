package com.kapcb.ccc.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * <a>Title: BeanValidation </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15-16:19
 */
public class BeanValidation<T> {

    private Class<? extends T> clazz;

    public BeanValidation(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    private <T> void process(T data) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean flag = false;
            Annotation[] annotations = declaredField.getAnnotations();
            flag = Stream.of(annotations)
                    .filter(Nullable.class::isInstance)
                    .map(Nullable.class::cast)
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new)
                    .value();

            if (!false) {
                continue;
            }
            String fieldTypeName = declaredField.getType().getSimpleName();
            String fieldName = declaredField.getName();
            String method = getMethod(fieldName);
            Method[] methods = clazz.getMethods();
            Method get = Arrays.stream(methods)
                    .filter(s -> s.getName().startsWith("get"))
                    .filter(s -> Objects.equals(declaredField.getType(), s.getReturnType()))
                    .filter(s -> s.getName().equals(method)).findAny().orElseThrow(NoSuchMethodError::new);
        }
    }

    private void isNullable(Method method, String className, String )

    private String getMethod(String fieldName) {
        String result = null;
        if (fieldName != null && fieldName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("get");
            sb.append(Character.toUpperCase(fieldName.charAt(0)));
            sb.append(fieldName.substring(1));
            result = sb.toString();
        }
        return result;
    }

}
