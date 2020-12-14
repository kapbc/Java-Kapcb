package com.kapcb.ccc.java.stream.parallel;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * <a>Title: ParallelStream </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-17:04
 */
public class ParallelStream {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(Constants.COMMON_STREAM_TEST_TXT_RESOURCES_PATH.getStringStatusCode())), StandardCharsets.UTF_8);
        Stream<String> parallel = Stream.of(contents).parallel();

        String[] split = contents.split("");
        Stream<String> stringStream = Stream.of(split).parallel();

        String[] contentsArray = contents.split("\\PL+");
        Map<Integer, Set<String> >collect = Arrays.stream(contentsArray).parallel().filter(s -> s.length() > 3).collect(groupingBy(String::length, toSet()));
        System.out.println("collect = " + collect);
    }
}
