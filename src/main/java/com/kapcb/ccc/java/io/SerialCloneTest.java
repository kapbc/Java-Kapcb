package com.kapcb.ccc.java.io;

import java.time.LocalDate;

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
        Employee kapcb = new Employee("kapcb", 2000, LocalDate.now());
        Employee clone = (Employee) kapcb.clone();

        kapcb.raiseSalary(10);

        System.out.println("kapcb = " + kapcb);
        System.out.println("clone = " + clone);

    }
}
