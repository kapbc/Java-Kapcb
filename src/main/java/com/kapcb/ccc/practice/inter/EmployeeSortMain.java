package com.kapcb.ccc.practice.inter;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname EmployeeSortMain
 * @date 2020/11/2 16:03
 */
public class EmployeeSortMain {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("kapcb", 50000);
        employees[1] = new Employee("ccc", 40000);
        employees[2] = new Employee("eirc", 30000);

        Arrays.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
