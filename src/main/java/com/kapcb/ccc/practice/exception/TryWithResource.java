package com.kapcb.ccc.practice.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname TryWithResource
 * @date 2020/11/10 11:11
 */
public class TryWithResource {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileInputStream("path"), String.valueOf(StandardCharsets.UTF_8))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
