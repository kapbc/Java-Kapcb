package com.kapcb.ccc.java.io;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * <a>Title: InputStreamTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/4-11:07
 */
public class IoStreamTest {

    private static final String SPILT = File.separator;
    private static final String INPUT_PATH = "src" + SPILT + "main" + SPILT + "resource" + SPILT + "dat" + SPILT + "employee.dat";
    private static final String OUT_PUT_PATH = "src" + SPILT + "main" + SPILT + "resource" + SPILT + "dat" + SPILT + "out.txt";

    public static void main(String[] args) {
        System.out.println("PATH = " + INPUT_PATH);
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(INPUT_PATH)));
             FileOutputStream outputStream = new FileOutputStream(OUT_PUT_PATH);
             PrintWriter printWriter = new PrintWriter(outputStream, true)) {
            while (dataInputStream.read() != -1) {
                int read = dataInputStream.read();
                System.out.println("read = " + read);
            }

            String name = "kapcb";
            Double salary = 7500.00;
            printWriter.println(name);
            printWriter.println(salary);

            FileInputStream fileInputStream = new FileInputStream("src/main/resource/dat/out.txt");
            while (fileInputStream.read() != -1) {
                System.out.println("fileInputStream.read() = " + fileInputStream.read());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resource/dat/out.txt"), StandardCharsets.UTF_8));
            while (bufferedReader.readLine() != null) {
                System.out.println("bufferedReader.read() = " + bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
