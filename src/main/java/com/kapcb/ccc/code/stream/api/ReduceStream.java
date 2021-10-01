package com.kapcb.ccc.code.stream.api;

import com.kapcb.ccc.code.think.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * <a>Title: ReduceStream </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-15:14
 */
public class ReduceStream {

    public static void main(String[] args) {
        List<com.kapcb.ccc.code.think.Employee> employees = new LinkedList<>();
        employees.add(new Employee("kapcb", 5000, 1997, 03, 11));
        employees.add(new Employee("ccccc", 4000, 1998, 04, 13));
        employees.add(new Employee("eeeee", 3000, 1999, 05, 15));
        employees.add(new Employee("bbbbb", 2000, 1996, 06, 17));
        employees.add(new Employee("aaaaa", 2500, 1995, 06, 23));
        employees.add(new Employee("ddddd", 1000, 1994, 07, 12));

        // Optional<Double> reduce = employees.stream().map(Employee::getSalary).reduce((x, y) -> x + y);
        Optional<Double> reduce = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce.orElse(Double.valueOf(0)));

        Double result = employees.stream().map(Employee::getSalary).reduce(0d, Double::sum);
        System.out.println("result = " + result);

        Integer totalWordsLength = employees.stream().map(Employee::getName).reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
        System.out.println("totalWordsLength = " + totalWordsLength);
    }
}
