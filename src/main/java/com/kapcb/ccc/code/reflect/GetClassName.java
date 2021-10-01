package com.kapcb.ccc.code.reflect;

/**
 * <a>Title: GetClassName </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/22 - 21:55
 */
public class GetClassName {

    public static void main(String[] args) {

        Class<Person> personClass = Person.class;
        String name = personClass.getName();
        System.out.println("name = " + name);
    }
}
