package com.kapcb.ccc.code.test.ai;

import java.util.Scanner;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname AiMain
 * @date 2020/11/11 13:21
 */
public class AiMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            String next = "";
            while (true) {
                next = scanner.next();
                next = next.replace("吗", "");
                next = next.replace("?", "!");
                next = next.replace("? ", "!");
                System.out.println(next);
            }
        }
    }
}
