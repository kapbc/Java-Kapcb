package com.kapcb.ccc.code.reflect;

import java.lang.reflect.Field;

/**
 * <a>Title: GetDeclaredFields </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/21 - 22:57
 */
public class GetDeclaredFields {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;

        /**
         * getDeclaredFields()：获取所有的成员变量，不考虑修饰符
         */
        Field[] declaredFields = personClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }

        System.out.println("==============================");
        Field password = personClass.getDeclaredField("password");

        Person person = new Person();

        password.setAccessible(true);
        password.set(person,"123456");
        Object value = password.get(person);
        System.out.println("value = " + value);
    }
}
