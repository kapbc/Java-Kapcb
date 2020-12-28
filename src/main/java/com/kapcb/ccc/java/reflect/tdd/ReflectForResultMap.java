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

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Map<String, String> resultMap = new HashMap<>(10);
        resultMap.put("user_name", "kapcb");
        resultMap.put("pass_word", "123456");
        resultMap.put("l_upd_date", "2020-11-21 14:41:06:612");

        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            String nameFromDB = "";
            Annotation[] annotations = declaredField.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column column = (Column) annotation;
                    nameFromDB = column.name();
                    System.out.println("nameFromDB = " + nameFromDB);
                    //System.out.println(column.name());
                }
            }

            String simpleName = declaredField.getType().getSimpleName();
            String name = declaredField.getName();
//            System.out.println("simpleName = " + simpleName);
//            System.out.println("name = " + name);
//            System.out.println("declaredField.getType() = " + declaredField.getType());
            String s = parseSetMethodName(name);
            System.out.println("s = " + s);
            Method method = null;
            try {
                method = personClass.getMethod(parseSetMethodName(name), declaredField.getType());
                System.out.println("method = " + method);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            method.invoke(person, resultMap.get(nameFromDB));
        }

        System.out.println("person = " + person);

    }

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
