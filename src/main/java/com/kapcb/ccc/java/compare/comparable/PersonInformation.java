package com.kapcb.ccc.java.compare.comparable;

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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: PersonInformation </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 21:02
 */
public class PersonInformation {

    private static final Path PATH = Paths.get(Constants.COMMON_EMAIL_HANDLER_RESOURCES_PATH.getStringStatusCode());

    private static final Logger logger = Logger.getLogger(String.valueOf(PersonInformation.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    public static void main(String[] args) {
        /**
         * 内部排序 Person类实现了Comparable接口     ==> 可比较的
         */
        try (Stream<String> lines = Files.lines(PATH, StandardCharsets.UTF_8)) {
            lines.map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).map(element -> new Person(
                    Long.valueOf(element[0]),
                    element[1],
                    element[2],
                    element[3],
                    Integer.valueOf(element[4]),
                    Integer.valueOf(element[5]),
                    Integer.valueOf(element[6]),
                    LocalDateTime.parse(element[7], dateTimeFormatter)
            )).sorted().collect(Collectors.toList()).forEach(System.out::println);
        } catch (IOException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("==================外部自定义比较器===================");

        /**
         * 外部排序, PersonLastUpdateDateComparator 比较器     ==> 比较器
         */
        try (Stream<String> lines = Files.lines(PATH, StandardCharsets.UTF_8)) {
            lines.map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).map(element -> new Person(
                    Long.valueOf(element[0]),
                    element[1],
                    element[2],
                    element[3],
                    Integer.valueOf(element[4]),
                    Integer.valueOf(element[5]),
                    Integer.valueOf(element[6]),
                    LocalDateTime.parse(element[7], dateTimeFormatter)
            )).sorted(new PersonLastUpdateDateComparator()).collect(Collectors.toList()).forEach(System.out::println);
        } catch (IOException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE + e.getMessage());
            e.printStackTrace();
        }


        System.out.println("=================代码内部自己定义比较器====================");
        /**
         * 外部排序, 根据自定义的比较器 comparator       ==> 比较器
         */
        Comparator<Person> comparator = Comparator.comparing(Person::getLastUpdateDate).thenComparingLong(Person::getUserId);
        try (Stream<String> lines = Files.lines(PATH, StandardCharsets.UTF_8)) {
            lines.map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).map(element -> new Person(
                    Long.valueOf(element[0]),
                    element[1],
                    element[2],
                    element[3],
                    Integer.valueOf(element[4]),
                    Integer.valueOf(element[5]),
                    Integer.valueOf(element[6]),
                    LocalDateTime.parse(element[7], dateTimeFormatter)
            )).sorted(comparator).collect(Collectors.toList()).forEach(System.out::println);
        } catch (IOException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE + e.getMessage());
            e.printStackTrace();
        }
    }
}
