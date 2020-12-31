package com.kapcb.ccc.java.reflect.tdd;

import com.kapcb.ccc.util.Constants;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * <a>Title: ResultMapping </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/31-15:14
 */
public class ResultMapping<T> {

    private static final Logger logger = Logger.getLogger(String.valueOf(ResultMapping.class));

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    private final Class<? extends T> clazz;

    public ResultMapping(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public T resultMapper(Map<String, String> resultMap) throws Exception {
        logger.warning("---Come into the resultMapper---");
        T bean = null;
        try {
            bean = clazz.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : Objects.requireNonNull(declaredFields)) {
                String annotationName = "";
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : Objects.requireNonNull(annotations)) {
                    if (annotation instanceof Column) {
                        Column column = (Column) annotation;
                        annotationName = column.name();
                    }
                }

                String fieldType = field.getType().getSimpleName();
                String fieldName = field.getName();
                String setMethodName = parseSetMethodName(fieldName);
                Method setMethod = clazz.getMethod(Objects.requireNonNull(setMethodName), field.getType());
                getMappingResult(fieldType, annotationName, resultMap, bean, setMethod);
            }
        } catch (Exception e) {
            logger.warning("---resultMapper error---");
        }
        return Objects.equals(null, bean) ? clazz.getConstructor().newInstance() : bean;
    }

    private void getMappingResult(String fieldType, String annotationName, Map<String, String> resultMap, Object bean, Method setMethod) {
        try {
            if (Objects.equals(null, resultMap.get(annotationName))) {
                logger.warning("The " + annotationName + " is null!");
                return;
            }
            switch (fieldType) {
                case "String":
                    setMethod.invoke(bean, String.valueOf(resultMap.get(annotationName)));
                    break;
                case "int":
                case "Integer":
                    setMethod.invoke(bean, Integer.valueOf(resultMap.get(annotationName)));
                    break;
                case "long":
                case "Long":
                    setMethod.invoke(bean, Long.valueOf(resultMap.get(annotationName)));
                    break;
                case "float":
                case "double":
                case "Float":
                case "Double":
                    setMethod.invoke(bean, Double.valueOf(resultMap.get(annotationName)));
                    break;
                case "Boolean":
                    setMethod.invoke(bean, Boolean.valueOf(resultMap.get(annotationName)));
                    break;
                case "LocalDateTime":
                    setMethod.invoke(bean, LocalDateTime.parse(resultMap.get(annotationName), DATE_TIME_FORMATTER));
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.warning("---Convert the data error---");
        }
    }

    private String parseSetMethodName(String fieldName) {
        if (Objects.equals(null, fieldName) || Objects.equals("", fieldName)) {
            return null;
        }
        StringBuilder set = new StringBuilder("set");
        set.append(Character.toUpperCase(fieldName.charAt(0)));
        set.append(fieldName.substring(1));
        logger.warning("setMethodName ::: " + set.toString());
        return set.toString();
    }
}
