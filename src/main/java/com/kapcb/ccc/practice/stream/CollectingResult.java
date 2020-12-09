package com.kapcb.ccc.practice.stream;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: CollectingResult </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/9-15:36
 */
public class CollectingResult {

    private static final Logger logger = Logger.getLogger(String.valueOf(CollectingResult.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(Constants.COMMON_STREAM_TEST_TXT_RESOURCES_PATH.getStringStatusCode())), StandardCharsets.UTF_8);
        List<String> list = new ArrayList<>(Arrays.asList(contents.split("\\PL+")));
        return list.stream().map(s -> s.replaceAll("The", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.println(label + " : " + set.getClass().getName());
        System.out.println("[ " + set.stream().limit(10).map(Objects::toString).collect(Collectors.joining(", ")) + " ]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iterator = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println(Arrays.toString(numbers));

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("number = " + number);
            System.out.println("The following statement throws an exception: ");
            Integer[] number1 = (Integer[]) numbers;
        } catch (ClassCastException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_INFO.getStringStatusCode() + e +
                    Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE.getStringStatusCode() + e.getMessage());
        }

        Integer[] integers = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("integers = " + integers);

        Set<String> collect = noVowels().collect(Collectors.toSet());
        show("noVowelsTreeSet", collect);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining = " + result);
        result = noVowels().limit(10).collect(Collectors.joining(", "));
        System.out.println("Joining with commas: " + result);

        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("forEach: ");
        noVowels().limit(10).forEach(System.out::println);
    }
}
