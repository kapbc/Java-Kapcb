package com.kapcb.ccc.java.stream;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: SubStreamTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10-15:44
 */
public class SubStreamTest {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(Constants.COMMON_STREAM_TEST_TXT_RESOURCES_PATH.getStringStatusCode());
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> skip = Arrays.stream(contents.split("\\PL+")).skip(1);
        skip.forEach(System.out::println);

        Stream.of("merrily", "merrily", "merrily", "kapcb").distinct().forEach(System.out::println);


        List<String> resultList = Stream.of("a", "ab", "dsad", "dsdwda", "ds", "dsa", "d", "dsadasdasdasdf", "dsdsada").sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println(resultList);

        List<String> collect = Stream.of("a", "ab", "dsad", "dsdwda", "ds", "dsa", "d", "dsadasdasdasdf", "dsdsada").sorted().collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> result = new ArrayList<>();
        Stream.iterate(Constants.COMMON_NUMBER_ONE.getNumberStatusCode(), s -> s + 1).peek(result::add).limit(10).toArray();
        System.out.println(result);

        Optional<String> largest = Stream.of("merrily", "merrily", "merrily", "kapcb").max(String::compareToIgnoreCase);
        System.out.println("largest: " + largest.orElse(""));
    }
}
