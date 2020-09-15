package com.kapcb.ccc.awt;

import java.util.Scanner;

/**
 * <a>Title:LotteryOdds</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/9/15 22:53
 */
public class LotteryOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int i = scanner.nextInt();

        System.out.println("What is the highest number you can draw?");
        int i1 = scanner.nextInt();

        int lotteryOdds = 1;
        for (int j = 1; j < i; j++) {
            lotteryOdds = lotteryOdds * (i1 - j + 1) / j;
        }
        System.out.println("Your odds are 1 in " + lotteryOdds);
    }
}
