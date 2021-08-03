package com.kapcb.ccc.java.stream.api;

import com.kapcb.ccc.java.think.Employee;
import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * <a>Title: StreamApi </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/8 - 20:38
 */
public class StreamApi {

    private static final Logger logger = Logger.getLogger(String.valueOf(StreamApi.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private static final List<Employee> EMPLOYEES = new ArrayList<Employee>() {{
        add(new Employee("kapcb", 5000, 1997, 03, 11));
        add(new Employee("ccccc", 4000, 1998, 04, 13));
        add(new Employee("eeeee", 3000, 1999, 05, 15));
        add(new Employee("bbbbb", 2000, 1996, 06, 17));
        add(new Employee("aaaaa", 2500, 1995, 06, 23));
        add(new Employee("ddddd", 1000, 1994, 07, 12));
    }};

    public static void main(String[] args) {

        /**
         * filter
         */
        System.out.println("-------------filter-------------");
        List<String> list = Arrays.asList("Java", "JavaScript", "python", "PHP", "C#", "Golang", "Swift", "C++", "Ruby");
        list.stream().filter(element -> element.startsWith("J")).map(String::toLowerCase).collect(Collectors.toCollection(LinkedBlockingDeque::new)).forEach(System.out::println);

        /**
         * distinct
         */
        System.out.println("-------------distinct-------------");
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 2, 5);
        number.stream().filter(element -> element % 2 == 0).distinct().forEach(System.out::println);

        /**
         * skip
         */
        System.out.println("-------------skip-------------");
        list.stream().filter(element -> element.startsWith("J")).skip(1).map(String::toLowerCase).collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);

        /**
         * limit
         */
        System.out.println("-------------limit-------------");
        EMPLOYEES.stream().filter(element -> element.getSalary() >= 3000).limit(1).map(Employee::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);

        /**
         * map
         */
        System.out.println("-------------map-------------");
        EMPLOYEES.stream().filter(element -> element.getSalary() <= 2000).map(Employee::getName).map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);

        /**
         * flatMap
         */
        System.out.println("-------------flatMap-------------");
        EMPLOYEES.stream().filter(element -> element.getSalary() > 2000).map(Employee::getName).map(element -> element.split("")).distinct().flatMap(Arrays::stream).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);

        /**
         * anyMatch
         */
        System.out.println("-------------anyMatch-------------");
        boolean flag = EMPLOYEES.stream().filter(element -> element.getSalary() > 2000).map(Employee::getName).anyMatch(element -> "kapcb".equals(element));
        System.out.println(flag);

        /**
         * allMatch
         */
        System.out.println("-------------allMatch-------------");
        boolean flagTwo = EMPLOYEES.stream().filter(element -> element.getSalary() > 2000).map(Employee::getName).allMatch(element -> element.length() > 2);
        System.out.println(flagTwo);

        /**
         * noneMatch
         */
        System.out.println("-------------noneMatch-------------");
        boolean flagThree = EMPLOYEES.stream().filter(element -> element.getSalary() > 2000).map(Employee::getName).noneMatch(element -> "12345".equals(element));
        System.out.println(flagThree);

        /**
         * findAny
         */
        System.out.println("-------------findAny-------------");
        EMPLOYEES.stream().filter(element -> element.getSalary() > 2000).map(Employee::getName).findAny().ifPresent(System.out::println);

        /**
         * findFirst
         */
        System.out.println("-------------findFirst-------------");
        EMPLOYEES.stream().filter(element -> element.getSalary() > 2000).map(Employee::getName).findFirst().ifPresent(System.out::println);

        /**
         * reduce
         */
        System.out.println("-------------reduce-------------");
        number.stream().filter(element -> element % 2 == 0).distinct().reduce(Integer::sum).ifPresent(System.out::println);

    }
}
