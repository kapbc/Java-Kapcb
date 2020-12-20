package com.kapcb.ccc.java.reflect;

import com.kapcb.ccc.java.compare.comparable.Person;

/**
 * <a>Title: ClassLoadTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 17:37
 */
public class ClassLoadTest {

    public static void main(String[] args) throws ClassNotFoundException {

        // 方式一: Class.forName(全类名)
        Class personClassOne = Class.forName("com.kapcb.ccc.java.compare.comparable.Person");
        System.out.println("personClassOne = " + personClassOne);

        // 方式二: 类名.class
        Class<Person> personClassTwo = Person.class;
        System.out.println("personClassTwo = " + personClassTwo);

        // 对象.getClass()
        Person person = new Person();
        Class<? extends Person> personClassThree = person.getClass();
        System.out.println("personClassThree = " + personClassThree);

        // 同一个字节码文件在一次程序运行中, 只会被加载一次, 无论通过哪种方式获取的Class对象都是同一个
        System.out.println(personClassOne == personClassTwo);
        System.out.println(personClassOne == personClassThree);
    }
}
