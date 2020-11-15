package com.kapcb.ccc.leetcode;

import java.util.Stack;

/**
 * <a>Title: RemoveKDigits </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/15 - 17:46
 * <p>
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * link: https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        String number = "1432219";
        int k = 3;
        int theResult = getTheResult(number, k);
        System.out.println(theResult);
    }

    /**
     * 贪心算法 + 栈
     * 先记录下，等会了再来
     *
     * @param number String
     * @param k      int
     * @return int
     */
    private static int getTheResult(String number, int k) {
        Stack<Integer> integerStack = new Stack<>();
        String[] split = number.split("");
        for (int i = 0; i < split.length; i++) {
            Integer peek = integerStack.peek();
            // TODO continue;
        }
        return 0;
    }
}
