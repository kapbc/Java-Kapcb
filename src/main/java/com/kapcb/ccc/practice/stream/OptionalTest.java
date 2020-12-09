package com.kapcb.ccc.practice.stream;

import com.kapcb.ccc.practice.exception.OptionalException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <a>Title: OptionalTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/9-10:44
 */
public class OptionalTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(OptionalTest.class), "logmessage_en");

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "JavaScript", "python", "PHP", "C#", "Golang", "Swift", "C++", "Ruby");
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 2, 5);


        /**
         * Optional
         */
        System.out.println("----------------Optional---------------");
        Optional<String> stringMax = list.stream().max(String::compareToIgnoreCase);
        System.out.println(stringMax.orElse(""));
        Optional<Integer> integerMax = number.stream().max(Integer::compareTo);
        System.out.println(integerMax.orElse(0));

        Optional<String> optionalJ = list.stream().filter(element -> element.startsWith("J")).findFirst();
        System.out.println(optionalJ.orElse(""));

        Optional<String> optionalC = list.stream().parallel().filter(element -> element.startsWith("C")).findAny();
        System.out.println(optionalC.orElse(""));

        try (FileInputStream fileInputStream = new FileInputStream("src/main/resource/logmessage_en.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String result = list.parallelStream().filter("1234"::equals).findAny().orElseGet(() -> properties.getProperty("kapcb.stream.test"));
            System.out.println(result);
        } catch (FileNotFoundException e) {
            logger.warning("The Exception is : " + e);
        } catch (IOException e) {
            logger.warning("The Exception is : " + e);
        }


        try (FileInputStream fileInputStream = new FileInputStream("src/main/resource/start.properties")) {
            String result = list.parallelStream().filter("1234"::equals).findAny().orElseThrow(OptionalException::new);
            System.out.println(result);
        } catch (Exception e) {
            logger.warning("The Exception is : " + e + ", the message is : " + e.getMessage());
        }

        List<String> addAndRemoveAbleList = new ArrayList<>(list);
        number.parallelStream().filter(Integer.valueOf(6)::equals).findAny().ifPresent(element -> addAndRemoveAbleList.add(String.valueOf(element)));
        addAndRemoveAbleList.forEach(System.out::println);
    }
}
