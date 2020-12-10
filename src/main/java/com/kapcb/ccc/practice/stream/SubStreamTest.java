package com.kapcb.ccc.practice.stream;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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

    }
}
