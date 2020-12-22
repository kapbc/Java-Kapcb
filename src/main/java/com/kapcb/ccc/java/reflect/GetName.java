package com.kapcb.ccc.java.reflect;

import java.lang.reflect.Method;

/**
 * <a>Title: GetName </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/22 - 21:51
 */
public class GetName {

    public static void main(String[] args) {

        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
