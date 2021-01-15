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

    public void valid(T data) {
        try {
            judgement(data);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void judgement(T data) throws InvocationTargetException, IllegalAccessException {
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
                validateData(fieldName, Objects.requireNonNull(getMethod), data, clazz.getSimpleName());
            }
        }
    }

    private void validateData(String fieldName, Method getMethod, T data, String className) throws InvocationTargetException, IllegalAccessException {
        if (Objects.equals(null, getMethod.invoke(data))) {
            StringBuilder exceptionMessage = new StringBuilder();
            exceptionMessage.append("The column ").append(fieldName);
            exceptionMessage.append(" of the ").append(className);
            exceptionMessage.append(" Bean is required not null. Please get the right arguments injection!").append("\n");
            exceptionMessage.append(" Please check the program where the property ' " + fieldName + " ' is injected for " + className + " Bean !");
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private String getSetMethodName(String fieldName) {
        StringBuilder sb = new StringBuilder();
        if (fieldName != null && fieldName.length() > 0) {
            sb.append("get");
            sb.append(Character.toUpperCase(fieldName.charAt(0)));
            sb.append(fieldName.substring(1));
        }
        return sb.toString();
    }
}
