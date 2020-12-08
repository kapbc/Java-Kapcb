package com.kapcb.ccc.practice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a>Title: TestStream </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/8-11:20
 */
public class TestStream {

    private static final String SEPARATOR_COMMA = ", ";

    public static void main(String[] args) {
        List<String> elementList = Arrays.asList("kapcb", "dsaddsadaas", "dsdsdsada", "dsadasdsd", "dsdsddsdd", "dsdsdsdsd", "nb!");
        List<String> collect = elementList.stream().filter(element -> element.length() <= 5).collect(Collectors.toList());
        System.out.println(collect);

        String result = elementList.parallelStream().filter(element -> element.length() <= 5).collect(Collectors.joining(SEPARATOR_COMMA));
        System.out.println(result);
    }
}
