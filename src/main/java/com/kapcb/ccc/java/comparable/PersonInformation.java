package com.kapcb.ccc.java.comparable;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    public static void main(String[] args) {
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
            e.printStackTrace();
        }
    }
}
