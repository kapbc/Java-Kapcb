package com.kapcb.ccc.java.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * <a>Title: SetTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-13:51
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        long totalTime = 0;
        try (Scanner scanner = new Scanner(System.in);) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                long callTime = System.currentTimeMillis();
                set.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < 20 && iterator.hasNext(); i++) {
            System.out.println(iterator.next());
            System.out.println("....");
            System.out.println(set.size() + " distinct words." + totalTime + " milliseconds.");
        }
    }
}
