package com.kapcb.ccc.java.stream;

import com.kapcb.ccc.java.think.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: CollectionMapTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-14:37
 */
public class CollectionMapTest {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("kapcb", 5000, 1997, 03, 11));
        employees.add(new Employee("ccccc", 4000, 1998, 04, 13));
        employees.add(new Employee("eeeee", 3000, 1999, 05, 15));
        employees.add(new Employee("bbbbb", 2000, 1996, 06, 17));
        employees.add(new Employee("aaaaa", 2500, 1995, 06, 23));
        employees.add(new Employee("ddddd", 1000, 1994, 07, 12));

        Map<Double, String> resultMap = employees.stream().collect(Collectors.toMap(Employee::getSalary, Employee::getName));
        resultMap.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));

        Map<Double, Employee> collect = employees.stream().collect(Collectors.toMap(Employee::getSalary, Function.identity()));
        collect.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));

        /**
         * Map<String, String>
         */
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = availableLocales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        locale -> locale.getDisplayLanguage(locale),
                        (existingValue, newValue) -> existingValue));
        languageNames.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));


        /**
         * Map<String, Set<String>>
         */
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        locales.collect(Collectors.toMap(Locale::getDisplayCountry, locale -> Collections.singleton(locale.getDisplayLanguage()), (a, b) -> {
            Set<String> union = new HashSet<>();
            union.addAll(b);
            return union;
        })).forEach((k, v) -> {
            System.out.println("k=" + k + ", v=" + v);
            // v.forEach(System.out::println);
        });

        /**
         * Map<Double, Employee>
         */
        Map<Double, Employee> treeMap = employees.stream().collect(
                Collectors.toMap(
                        Employee::getSalary,
                        Function.identity(),
                        (oldValue, newValue) -> {
                            throw new IllegalStateException();
                        },
                        TreeMap::new));
    }
}
