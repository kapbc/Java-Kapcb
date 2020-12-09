package com.kapcb.ccc.practice.stream;

import com.kapcb.ccc.practice.exception.OptionalException;
import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

/**
 * <a>Title: OptionalTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/9-13:29
 */
public class OptionalTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(OptionalTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("src/main/resource/streamTest.txt")), StandardCharsets.UTF_8);
        // \PL+ 以单词
        List<String> wordList = new ArrayList<>(Arrays.asList(contents.split("\\PL+")));
        Optional<String> optionalValue = wordList.stream().filter("man"::contains).findFirst();
        System.out.println(optionalValue.orElse("No Match Words"));

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result = " + result);

        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result = " + result);

        try {
            result = optionalString.orElseThrow(OptionalException::new);
            System.out.println("result = " + result);
        } catch (OptionalException e) {
            logger.warning("The Exception is : " + e + ", the message is : " + e.getMessage());
        }

        optionalValue = wordList.stream().filter("boy"::contains).findFirst();
        optionalValue.ifPresent(System.out::println);

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        results.forEach(System.out::println);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println("added = " + added);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> aDouble = Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(aDouble);
    }

    private static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    private static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
