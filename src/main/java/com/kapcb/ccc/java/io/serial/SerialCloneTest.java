package com.kapcb.ccc.java.io.serial;


import com.kapcb.ccc.java.io.bean.Employee;

/**
 * <a>Title: SerialCloneTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-14:10
 */
public class SerialCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee kapcb = new Employee("kapcb", 2000, 2020, 01, 23);
        Employee clone = (Employee) kapcb.clone();

        kapcb.raiseSalary(10);

        System.out.println("kapcb = " + kapcb);
        System.out.println("clone = " + clone);

    }
}
