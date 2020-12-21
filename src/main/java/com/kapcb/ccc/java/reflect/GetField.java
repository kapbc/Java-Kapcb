package com.kapcb.ccc.java.reflect;

import java.lang.reflect.Field;

/**
 * <a>Title: GetField </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/21 - 22:48
 */
public class GetField {

    public static void main(String[] args) throws IllegalAccessException {
        /**
         * 获取Person的Class对象
         */
        Class<Person> personClass = Person.class;

        /**
         * getFields() 获取所有 public 修饰的成员变量
         */
        Field[] fields = personClass.getFields();

        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("==========================");

        /**
         * 获取成员变量 username 的值 [也只能获取公有的，获取私有的或者不存在的字符会抛出异常]
         */
        Field username = null;
        try {
            username = personClass.getField("username");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Person person = new Person();
        Object value = null;
        try {
            value = username.get(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("value = " + value);

        username.set(person,"kapcb");
        System.out.println("person = " + person);

        value = username.get(person);
        System.out.println("value = " + value);
    }
}
