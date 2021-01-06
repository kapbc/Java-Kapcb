package com.kapcb.ccc.java.io.random;

import com.kapcb.ccc.java.io.FixedDataIo;
import com.kapcb.ccc.java.io.bean.Person;
import com.kapcb.ccc.util.Constants;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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

    public static void main(String[] args) throws IOException {
        Person[] people = new Person[]{
                new Person("kapcb", "eircccallroot@163.com", 18, LocalDateTime.now()),
                new Person("eric", "eircccallroot@126.com", 19, LocalDateTime.now()),
                new Person("ccc", "eircccallroot@yeah.com", 20, LocalDateTime.now()),
        };

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(TEXT_FILE_PATH))) {
            for (Person person : people) {
                writeData(person, dataOutputStream);
            }
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(TEXT_FILE_PATH, "r")) {
            int n = (int) (randomAccessFile.length() / Person.RECORD_SIZE);

            Person[] p = new Person[n];
            for (int i = n - 1; i >= 0; i--) {
                p[i] = new Person();
                randomAccessFile.seek(i * Person.RECORD_SIZE);
                p[i] = readData(randomAccessFile);
            }
            for (Person person : p) {
                System.out.println("person = " + person);
            }
        }
    }

    private static Person readData(RandomAccessFile randomAccessFile) throws IOException {
        String name = FixedDataIo.readFixedString(Person.NAME_SIZE, randomAccessFile);
        int age = randomAccessFile.readInt();
        return new Person(name, "123@123.com", age, LocalDateTime.now());
    }

    private static void writeData(Person person, DataOutputStream dataOutputStream) throws IOException {
        FixedDataIo.writeFixedString(person.getName(), Person.NAME_SIZE, dataOutputStream);
        dataOutputStream.writeInt(person.getAge());
    }
}
