package com.kapcb.ccc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * <a>Title: FunctionInterface </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 22:27
 */
public class FunctionInterface {

    public static void main(String[] args) {
        List<String> resultList = new ArrayList<>();
        resultList.add("kapcb");
        resultList.add("ccc");
        resultList.add("1234567");
        resultList.add("eweadsadasd");
        resultList.add("dasdasdsadsadas");
        resultList.add("ndsufjnajfhadsfasf");

        List<String> function = getFunction(resultList, String::toUpperCase);
        function.forEach(System.out::println);
        System.out.println("=====================================");
        List<String> prediction = getPrediction(resultList, s -> s.length() <= 5);
        prediction.forEach(System.out::println);
        System.out.println("=====================================");
        Random random = new Random();
        List<Integer> supplier = getSupplier(3, () -> random.nextInt(10));
        supplier.forEach(System.out::println);
        System.out.println("=====================================");
        List<String> list = new ArrayList<>();
        getConsumer(resultList, list::add);
        list.forEach(System.out::println);
    }

    private static List<String> getFunction(List<String> list, Function<String, String> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    private static List<String> getPrediction(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    private static List<Integer> getSupplier(int loop, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    private static void getConsumer(List<String> list, Consumer<String> consumer) {
        list.forEach(consumer);
    }
}
