package com.kapcb.ccc.java.annotation.bean;

import com.kapcb.ccc.java.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

    private static final String GET_SIGNATURE = "get";

    private Class<? extends T> clazz;

    public BeanValidation(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public void validate(T data) {
        try {
            process(data);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void process(T data) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean flag = false;
            Annotation[] annotations = declaredField.getAnnotations();
            if (annotations.length > 0) {
                flag = Stream.of(annotations)
                        .filter(Nullable.class::isInstance)
                        .map(Nullable.class::cast)
                        .anyMatch(Nullable::value);
            }
            if (!flag) {
                continue;
            }
            String fieldName = declaredField.getName();
            String method = getMethod(fieldName);
            Method[] methods = clazz.getMethods();
            Method get = Arrays.stream(methods)
                    .filter(s -> s.getName().startsWith(GET_SIGNATURE))
                    .filter(s -> Objects.equals(declaredField.getType(), s.getReturnType()))
                    .filter(s -> s.getName().equals(method))
                    .findAny()
                    .orElseThrow(NoSuchMethodException::new);

            isNullable(get, clazz.getSimpleName(), data, fieldName);
        }
    }

    private void isNullable(Method get, String beanName, T data, String fieldName) throws InvocationTargetException, IllegalAccessException {
        if (Objects.equals(get.invoke(data), null)) {
            StringBuilder exceptionMessage = new StringBuilder();
            exceptionMessage.append("The column ").append(fieldName);
            exceptionMessage.append(" of the ").append(beanName);
            exceptionMessage.append(" Bean is required not null. ");
            exceptionMessage.append("Please get the right arguments injection!").append("\n");
            exceptionMessage.append("Please check the program where the property ' " + fieldName + " ' is injected for " + beanName + " Bean !");
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private String getMethod(String fieldName) {
        String result = null;
        if (fieldName != null && fieldName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(GET_SIGNATURE);
            sb.append(Character.toUpperCase(fieldName.charAt(0)));
            sb.append(fieldName.substring(1));
            result = sb.toString();
        }
        return result;
    }
}
