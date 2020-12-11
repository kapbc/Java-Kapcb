package com.kapcb.ccc.java.lambda;

import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * <a>Title: FunctionInterface </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/30-15:25
 */
public class FunctionInterface {

    private static final Logger logger = Logger.getLogger(String.valueOf(FunctionInterface.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {
        List<Integer> list = testSupplierInterface(10, () -> (int) (Math.random() * 10));
        System.out.println(list);

        List<String> elementList = Arrays.asList("kapcb", "ccc", "eee", "nbnb", "!!!!");
        List<String> stringList = testPredicateInterface(elementList, value -> value.length() > 3);
        System.out.println(stringList);

        String test = testFunctionInterface("     kapcb       ", str -> str.trim());
        System.out.println(test);
        System.out.println(test.length());

        logger.warning("kapcb.test.dividing.line");
        testConsumerInterface(list, System.out::println);
    }

    /**
     * 供给型接口
     *
     * @param number int
     * @param sup    Supplier<Integer>
     * @return List<Integer>
     */
    private static List<Integer> testSupplierInterface(int number, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Integer result = sup.get();
            list.add(result);
        }
        return list;
    }

    /**
     * 断言型接口
     *
     * @param list      List<String>
     * @param predicate Predicate<String>
     * @return List<String>
     */
    private static List<String> testPredicateInterface(List<String> list, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();
        list.forEach(value -> {
            if (predicate.test(value)) {
                strList.add(value);
            }
        });
        return strList;
    }

    /**
     * 函数型接口
     *
     * @param str      String
     * @param function Function<String, String>
     * @return String
     */
    private static String testFunctionInterface(String str, Function<String, String> function) {
        return function.apply(str);
    }

    /**
     * 消费型接口
     *
     * @param list     List<Integer>
     * @param consumer Consumer<Integer>
     */
    private static void testConsumerInterface(List<Integer> list, Consumer<Integer> consumer) {
        list.forEach(value -> {
            if (value >= 4) {
                consumer.accept(value);
            }
        });
    }
}
