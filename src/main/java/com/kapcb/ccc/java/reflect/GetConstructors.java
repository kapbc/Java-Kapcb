package com.kapcb.ccc.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <a>Title: GetConstructors </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/22 - 20:58
 */
public class GetConstructors {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;

        Constructor<?>[] constructors = personClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }

        System.out.println("================================");

        /**
         * 获取无参构造函数   注意：Person类中必须要有无参的构造函数，不然抛出异常
         */
        Constructor<Person> constructor = personClass.getConstructor();
        System.out.println("constructor = " + constructor);

        Person person = constructor.newInstance();
        System.out.println("person = " + person);
        System.out.println("================================");

        /**
         * 获取有参的构造函数 参数类型顺序要与构造函数内一致，且参数类型为字节码类型
         */
        Constructor allArgsConstructor = personClass.getConstructor(String.class, String.class, String.class, String.class);
        System.out.println("allArgsConstructor = " + allArgsConstructor);

        /**
         * 创建对象
         */
        Object newInstance = allArgsConstructor.newInstance("kapcb", "123456", "eircccallroot@yeah.net", "Y");
        System.out.println("newInstance = " + newInstance);

        /**
         * 对于一般的无参构造函数，我们都不会先获取无参构造器之后在进行初始化。而是直接调用Class类内的newInstance()方法
         */
        Person personInstance = personClass.newInstance();
        System.out.println("personInstance = " + personInstance);
    }
}
