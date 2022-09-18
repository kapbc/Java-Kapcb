package com.kapcb.ccc.algorithm.book;

/**
 * <a>Title: aaa </a>
 * <a>Author: Kapcb <a>
 * <a>Description: aaa <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/21 19:16
 * @since 1.0
 */
public class Euclidean {

    /**
     * 欧几里得算法
     * 计算两个非负整数p和q的最大公约数: 若q是0,
     * 则最大公约是为p。否则, 将p除以q得到余数r,
     * p和q的最大公约数即为q和r的最大公约数。
     */
    private Euclidean() {
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int gcd = gcd(12, 7);
        System.out.println("gcd = " + gcd);
    }
}
