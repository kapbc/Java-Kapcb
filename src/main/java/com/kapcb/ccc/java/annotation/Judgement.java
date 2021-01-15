package com.kapcb.ccc.java.annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * <a>Title: Judgement </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15-13:30
 */
public class Judgement<T> {

    private final Class<? extends T> clazz;

    public Judgement(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public void judgement(T data) throws InvocationTargetException, IllegalAccessException {
        T bean = null;
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length >= 1) {
            for (Field field : fields) {
                boolean flag = false;
                Annotation[] annotations = field.getAnnotations();
                if (annotations.length >= 1) {
                    for (Annotation annotation : annotations) {
                        if (annotation instanceof Nullable) {
                            Nullable nullable = (Nullable) annotation;
                            flag = nullable.value();
                        }
                    }
                }
                if (!flag) {
                    continue;
                }
                String fieldName = field.getName();
                String getMethodName = getSetMethodName(fieldName);
                String fieldType = field.getType().getSimpleName();
                Method[] methods = clazz.getMethods();
                Method getMethod = null;
                if (methods.length >= 1) {
                    for (Method method : methods) {
                        if (Objects.equals(method.getName(), getMethodName) && Objects.equals(fieldType, method.getReturnType().getSimpleName())) {
                            getMethod = method;
                            break;
                        }
                    }
                }
                validateData(fieldName, Objects.requireNonNull(getMethod), data);
            }
        }
    }

    private void validateData(String fieldName, Method getMethod, T data) throws InvocationTargetException, IllegalAccessException {
        if (Objects.equals(null, getMethod.invoke(data))) {
            throw new IllegalArgumentException("The Column of " + fieldName + " is required not null. Please get the right arguments!");
        }
    }

    private String getSetMethodName(String fieldName) {
        System.out.println("fieldName = " + fieldName);
        StringBuilder sb = new StringBuilder();
        if (fieldName != null && fieldName.length() > 0) {
            sb.append("get");
            sb.append(Character.toUpperCase(fieldName.charAt(0)));
            sb.append(fieldName.substring(1));
            System.out.println("sb = " + sb.toString());
        }
        return sb.toString();
    }
}
