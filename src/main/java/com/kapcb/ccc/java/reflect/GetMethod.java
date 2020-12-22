package com.kapcb.ccc.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <a>Title: GetMethod </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/22 - 21:18
 */
public class GetMethod {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("==============================");

        /**
         * 获取指定名称的方法
         */
        Method methodNoArguments = personClass.getMethod("eat");
        System.out.println("methodNoArguments = " + methodNoArguments);

        Method methodsOneStringArguments = personClass.getMethod("eat", String.class);
        System.out.println("methodsOneStringArguments = " + methodsOneStringArguments);

        Method methodOneIntegerArguments = personClass.getMethod("eat", Integer.class);
        System.out.println("methodOneIntegerArguments = " + methodOneIntegerArguments);

        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();

        /**
         * 如果方法有返回值类型可以获取到，没有就为null
         * 无参方法
         */
        Object invokeNoArguments = methodNoArguments.invoke(person);
        System.out.println("invokeNoArguments = " + invokeNoArguments);

        /**
         * Integer类型参数方法
         */
        Object invokeOneIntegerArguments = methodOneIntegerArguments.invoke(person, 10);
        System.out.println("invokeOneIntegerArguments = " + invokeOneIntegerArguments);

        /**
         * String类型参数方法
         */
        Object invokeOneStringArguments = methodsOneStringArguments.invoke(person, "rice");
        System.out.println("invokeOneStringArguments = " + invokeOneStringArguments);
    }
}
