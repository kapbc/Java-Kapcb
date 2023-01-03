package com.kapcb.ccc.algorithm.huawei;

import java.util.Scanner;

/**
 * <a>Title: SteamBottle </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 汽水瓶 <a>
 * <a href="https://www.nowcoder.com/exam/test/64803032/detail?pid=1088888&examPageSource=Company&testCallback=https%3A%2F%2Fwww.nowcoder.com%2Fexam%2Fcompany&testclass=%E8%BD%AF%E4%BB%B6%E5%BC%80%E5%8F%91">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/1/3 11:23 PM
 * @since 1.0
 */
public class SteamBottle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int i = in.nextInt();

            if (i == 0) {
                break;
            }

            if (i == 1) {
                System.out.println(0);
                continue;
            }

            if (i == 2) {
                System.out.println(1);
                continue;
            }

            int c;
            int res = 0;
            while (i / 3 > 0) {
                int t = i / 3;
                c = i % 3;
                res += t;
                i = t + c;
            }

            if (i % 3 == 2) {
                res += 1;
            }

            System.out.println(res);
        }

    }

}
