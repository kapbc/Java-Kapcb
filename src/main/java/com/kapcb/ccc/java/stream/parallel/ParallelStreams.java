package com.kapcb.ccc.java.stream.parallel;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: ParallelStreams </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/15-14:43
 */
public class ParallelStreams {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(Constants.COMMON_ALICE_TXT_RESOURCES_PATH.getStringStatusCode())), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        /**
         * Bad Code Ahead
         */
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));

        /**
         * Try-Again -- The Result Will likely be different and also wrong
         */
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));
        
                Map<Integer, Long> shortWordCount = wordList.parallelStream().filter(s -> s.length() < 10).collect(groupingBy(String::length, counting()));
        System.out.println("shortWordCount = " + shortWordCount);
        
        Map<Integer, List<String>> result = wordList.parallelStream().collect(groupingByConcurrent(String::length));
        System.out.println(result.get(14));
        
        result = wordList.parallelStream().collect(groupingByConcurrent(String::length));
        System.out.println(result.get(14));

    }
}
