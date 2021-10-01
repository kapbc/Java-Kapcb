package com.kapcb.ccc.code.lambda;

import com.kapcb.ccc.code.think.Employee;
import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: FunctionInterfacePromotion </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10 - 22:36
 */
public class FunctionInterfacePromotion {

    private static final int CONSUMER_JUDGEMENT_NUMBER = 2000;

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee("kapcb", 5000, 1997, 03, 11));
        employees.add(new Employee("ccccc", 4000, 1998, 04, 13));
        employees.add(new Employee("eeeee", 3000, 1999, 05, 15));
        employees.add(new Employee("bbbbb", 2000, 1996, 06, 17));
        employees.add(new Employee("aaaaa", 2500, 1995, 06, 23));
        employees.add(new Employee("ddddd", 1000, 1994, 07, 12));

        List<Employee> resultList = new ArrayList<>();
        getConsumer(employees, resultList::add);
        resultList.stream().map(Employee::getName).forEach(System.out::println);

        List<Integer> supplier = getSupplier(Constants.COMMON_NUMBER_TEN.getNumberStatusCode(), () -> new Random().nextInt(Constants.COMMON_NUMBER_TEN.getNumberStatusCode()));
        System.out.println(supplier);

        List<String> predicate = getPredicate(employees, element -> element.getSalary() > CONSUMER_JUDGEMENT_NUMBER);
        System.out.println(predicate);

        List<String> function = getFunction(employees, String::toUpperCase);
        System.out.println(function);
    }

    /**
     * Consumer Interface
     *
     * @param list     List<Employee>
     * @param consumer Consumer<Employee>
     */
    private static void getConsumer(List<Employee> list, Consumer<Employee> consumer) {
        list.forEach(element -> {
            if (element.getSalary() > CONSUMER_JUDGEMENT_NUMBER) {
                consumer.accept(element);
            }
        });
    }

    /**
     * @param limit    int
     * @param supplier Supplier<Integer>
     * @return List<Integer>
     */
    private static List<Integer> getSupplier(int limit, Supplier<Integer> supplier) {
        return Stream.iterate(0, element -> element + supplier.get()).limit(limit).collect(Collectors.toList());
    }

    /**
     * Predicate Interface
     *
     * @param list      List<String>
     * @param predicate Predicate<Employee>
     * @return List<String>
     */
    private static List<String> getPredicate(List<Employee> list, Predicate<Employee> predicate) {
        return list.stream().filter(predicate).map(Employee::getName).collect(Collectors.toList());
    }

    /**
     * Function Interface
     *
     * @param list     List<String>
     * @param function Function<String, String>
     * @return List<String>
     */
    private static List<String> getFunction(List<Employee> list, Function<String, String> function) {
        return list.stream().filter(element -> element.getSalary() > CONSUMER_JUDGEMENT_NUMBER).map(Employee::getName).map(function).collect(Collectors.toList());
    }
}
