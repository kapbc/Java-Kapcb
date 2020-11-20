package com.kapcb.ccc.practice.collection;

import com.kapcb.ccc.practice.think.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a>Title: SubListTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-9:24
 */
public class SubListTest {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("kapcb", 5000, 1997, 03, 11));
        employees.add(new Employee("ccccc", 4000, 1998, 04, 13));
        employees.add(new Employee("eeeee", 3000, 1999, 05, 15));
        employees.add(new Employee("bbbbb", 2000, 1996, 06, 17));
        employees.add(new Employee("aaaaa", 2500, 1995, 06, 23));
        employees.add(new Employee("ddddd", 1000, 1994, 07, 12));
        employees.subList(0, 2).forEach(System.out::println);
    }
}
