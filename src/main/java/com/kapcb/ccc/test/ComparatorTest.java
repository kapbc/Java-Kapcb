package com.kapcb.ccc.test;

import com.kapcb.ccc.code.compare.comparable.Person;
import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * <a>Title: ComparatorTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/20 - 22:14
 */
public class ComparatorTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(ComparatorTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    private static final Path path = Paths.get(Constants.COMMON_EMAIL_HANDLER_RESOURCES_PATH.getStringStatusCode());

    public static void main(String[] args) {
        1
            1
            1
            1
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {

            Comparator<Person> comparator = Comparator.comparing(Person::getPrevWeekAddPoint).thenComparing(Person::getLastUpdateDate).thenComparing(Person::getUserId);

            lines.map(s -> s.split(", ")).map(s -> new Person(
                    Long.valueOf(s[0]),
                    s[1],
                    s[2],
                    s[3],
                    Integer.valueOf(s[4]),
                    Integer.valueOf(s[5]),
                    Integer.valueOf(s[6]),
                    LocalDateTime.parse(s[7], DATE_TIME_FORMATTER)
            )).sorted(comparator).forEach(System.out::println);
        } catch (IOException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_INFO.getStringStatusCode() + e +
                    Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE.getStringStatusCode() + e.getMessage());
            e.printStackTrace();
        }
    }
}
