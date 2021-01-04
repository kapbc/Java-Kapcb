package com.kapcb.ccc.java.io;

import com.kapcb.ccc.util.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <a>Title: RandomAccessTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/4-15:57
 */
public class RandomAccessTest {

    private static final String TEXT_FILE_PATH = "src/main/resource/dat/textfile.txt";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person("kapcb", "eircccallroot@163.com", 18, LocalDateTime.now()),
                new Person("eric", "eircccallroot@126.com", 19, LocalDateTime.now()),
                new Person("ccc", "eircccallroot@yeah.com", 20, LocalDateTime.now()),
        };
    }
}
