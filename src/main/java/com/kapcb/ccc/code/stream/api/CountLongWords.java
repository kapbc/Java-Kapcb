package com.kapcb.ccc.code.stream.api;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: CountLongWords </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10-10:44
 */
public class CountLongWords {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(Constants.COMMON_STREAM_TEST_TXT_RESOURCES_PATH.getStringStatusCode());
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> wordsList = Arrays.asList(contents.split("\\PL+"));

        long count = 0;
        for (String s : wordsList) {
            if (s.length() <= 5) {
                continue;
            }
            count++;
        }
        System.out.println(count);


        count = wordsList.stream().filter(s -> s.length() > 5).count();
        System.out.println(count);

        count = wordsList.parallelStream().filter(s -> s.length() > 5).count();
        System.out.println(count);
    }
}
