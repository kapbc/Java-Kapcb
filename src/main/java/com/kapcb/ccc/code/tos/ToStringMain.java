package com.kapcb.ccc.code.tos;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ToStringMain
 * @date 2020/11/2 11:14
 */
public class ToStringMain {
    public static void main(String[] args) {
        Employee ccc = new Employee("ccc", "123", "1234");
        System.out.println(ccc.toString());
        Manager manager = new Manager("kapcb", "ccc", "123", "123");
        System.out.println(manager.toString());
    }
}
