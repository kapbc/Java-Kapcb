package com.kapcb.ccc.java.clone;

import java.util.Date;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname CloneTest
 * @date 2020/11/3 10:20
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("kapcb", 50000, new Date());
        original.setHireDay(2020, 1, 1);
        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2020, 12, 30);
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
