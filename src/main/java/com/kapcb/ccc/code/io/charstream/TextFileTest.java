package com.kapcb.ccc.code.io.charstream;

import com.kapcb.ccc.code.io.bean.Person;
import com.kapcb.ccc.util.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * <a>Title: TextFileTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/4-14:19
 */
public class TextFileTest {

    private static final String TEXT_FILE_PATH = "src/main/resource/dat/textfile.txt";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

    public static void main(String[] args) throws FileNotFoundException {
        Person[] people = new Person[]{
                new Person("kapcb", "eircccallroot@163.com", 18, LocalDateTime.now()),
                new Person("eric", "eircccallroot@126.com", 19, LocalDateTime.now()),
                new Person("ccc", "eircccallroot@yeah.com", 20, LocalDateTime.now()),
        };

        try (PrintWriter printWriter = new PrintWriter(TEXT_FILE_PATH)) {
            storeData(printWriter, people);
        }

        try (Scanner scanner = new Scanner(new FileInputStream(TEXT_FILE_PATH), "UTF-8")) {
            Person[] result = readData(scanner);
            for (Person person : result) {
                System.out.println("person = " + person);
            }
        }
    }

    private static Person[] readData(Scanner scanner) {
        int n = scanner.nextInt(); // retrieve the array size

        scanner.nextLine(); // consume newline
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = readPersonData(scanner);
        }
        return people;
    }

    private static Person readPersonData(Scanner scanner) {
        String next = scanner.nextLine();
        String[] split = next.split("\\|");
        Person person = new Person();
        person.setName(split[0]);
        person.setEmail(split[1]);
        person.setAge(Integer.parseInt(split[2]));
        person.setBirthday(LocalDateTime.parse(split[3], DATE_TIME_FORMATTER));
        return person;
    }

    private static void storeData(PrintWriter printWriter, Person[] people) {
        printWriter.println(people.length);
        for (Person person : people) {
            printWriter.println(person.getName() + "|" + person.getEmail() + "|" + person.getAge() + "|" + person.getBirthday().format(DATE_TIME_FORMATTER));
        }
    }
}
