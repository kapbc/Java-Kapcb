package com.kapcb.ccc.java.collection;

import com.kapcb.ccc.java.think.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <a>Title: MaxInArrayTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-13:43
 */
public class MaxInArrayTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);

        Integer max = MaxInArray.getMaxInArray(list);
        System.out.println(max);

        System.out.println("-----------------------");

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee("kapcb", 5000, 1997, 03, 11));
        employees.add(new Employee("ccccc", 4000, 1998, 04, 13));
        employees.add(new Employee("eeeee", 3000, 1999, 05, 15));
        employees.add(new Employee("bbbbb", 2000, 1996, 06, 17));
        employees.add(new Employee("aaaaa", 2500, 1995, 06, 23));
        employees.add(new Employee("ddddd", 1000, 1994, 07, 12));
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        employees.forEach(System.out::println);

        System.out.println("-----------------------");

        employees.sort(Comparator.comparing(Employee::getHireDay));
        employees.forEach(System.out::println);
    }
}
