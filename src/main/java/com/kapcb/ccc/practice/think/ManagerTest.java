package com.kapcb.ccc.practice.think;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ManagerTest
 * @date 2020/10/30 8:57
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager kapcb = new Manager("kapcb", 80000, 1987, 12, 15);
        kapcb.setBonus(50000);
        Employee[] employees = new Employee[3];
        employees[0] = kapcb;
        employees[1] = new Employee("ccc", 50000, 1989, 10, 1);
        employees[2] = new Employee("eirc", 30000, 1990, 3, 15);
        for (Employee employee : employees) {
            System.out.println("name: " + employee.getName() + " ,salary: " + employee.getSalary());
        }
    }
}
