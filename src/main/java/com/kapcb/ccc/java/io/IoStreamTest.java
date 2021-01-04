package com.kapcb.ccc.java.io;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
