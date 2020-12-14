package com.kapcb.ccc.java.stream.collector;

import com.kapcb.ccc.java.think.Employee;
import com.kapcb.ccc.util.Constants;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: CollectionTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-13:42
 */
public class CollectionTest {

    public static void main(String[] args) {
        Stream<String> kapcb = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man");

        kapcb.forEach(System.out::println);

        // String[] result = kapcb.toArray(String[]::new); IllegalStateException Stream has already been operated upon or closed
        String[] result = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").toArray(String[]::new);
        System.out.println(Arrays.toString(result));


        List<String> resultList = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").collect(Collectors.toList());

        Set<String> resultSet = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").collect(Collectors.toSet());

        Set<String> resultTree = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").collect(Collectors.toCollection(TreeSet::new));

        String resultJoin = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").collect(Collectors.joining());

        String resultJoinComma = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").collect(Collectors.joining(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode()));
        System.out.println(resultJoinComma);

        String collect = Stream.of("kapcb", "nb", 1234, false, new Employee("ccc")).map(Object::toString).collect(Collectors.joining(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode()));
        System.out.println(collect);

        IntSummaryStatistics summary = Stream.of("kapcb", "nb", "!!!", "kapcb", "awesome", "man").collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double summaryMax = summary.getMax();
        double summaryMin = summary.getMin();
        double summaryCount = summary.getCount();
        System.out.println("averageWordLength = " + averageWordLength);
        System.out.println("summaryMax = " + summaryMax);
        System.out.println("summaryMin = " + summaryMin);
        System.out.println("summaryCount = " + summaryCount);
    }
}
