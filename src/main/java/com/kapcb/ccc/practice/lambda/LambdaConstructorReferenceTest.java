package com.kapcb.ccc.practice.lambda;

import com.kapcb.ccc.practice.think.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: LambdaConstructorReferenceTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/1-10:39
 */
public class LambdaConstructorReferenceTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("kapcb", "ccc", "eric", "tom", "three");
        Stream<Employee> employeeStream = list.stream().map(Employee::new);
        List<Employee> collect = employeeStream.collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
