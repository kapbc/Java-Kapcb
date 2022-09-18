package com.kapcb.ccc.algorithm.operation;

/**
 * <a>Title: XOROperation </a>
 * <a>Author: Kapcb <a>
 * <a>Description: XOROperation <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/20 12:04
 * @since 1.0
 */
public class XOROperation {

    private XOROperation() {
    }

    /**
     * 如果 a, b 地址的引用在堆中指向同一个地址的话会出错。
     *
     * @param a int
     * @param b int
     */
    private static void xorSwap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a is : " + a + ", b is : " + b);
    }

    private static void get(int a) {
        int i = ~a;
        System.out.println("i = " + i);
        int j = i + 1;
        System.out.println("j = " + j);
        int onlyOne = a & j;
        System.out.println("onlyOne = " + onlyOne);
    }

    /**
     * 异或运算
     * 无进制位相加: 相同为1, 不同为0
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        get(7);
    }

}
