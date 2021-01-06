package com.kapcb.ccc.java.io;

import com.kapcb.ccc.util.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * <a>Title: ReadTxtFileStringTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-15:52
 */
public class ReadTxtFileStringTest {

    private static final Path PATH = Paths.get(Constants.COMMON_MENU_TXT_RESOURCES_PATH.getStringStatusCode());
    private static final String PATH_STRING = Constants.COMMON_MENU_TXT_RESOURCES_PATH.getStringStatusCode();

    public static void main(String[] args) {
        try (InputStream inputStream = Files.newInputStream(PATH);
             Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("line = " + line);
            }

            try (FileReader fileReader = new FileReader(PATH_STRING);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while (bufferedReader.readLine() != null) {
                    System.out.println("bufferedReader = " + bufferedReader.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
