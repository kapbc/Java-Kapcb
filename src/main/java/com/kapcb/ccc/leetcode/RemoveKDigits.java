package com.kapcb.ccc.leetcode;

import com.kapcb.ccc.util.KapcbStartUp;

import java.util.Deque;
import java.util.LinkedList;
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
        KapcbStartUp.kapcbUp();
        String numberOne = "1432219";
        String numberTwo = "10200";
        String numberThree = "10";
        int k1 = 3;
        int k2 = 1;
        int k3 = 2;
        System.out.println(getTheResult(numberOne, k1));
        System.out.println(getTheResult(numberTwo, k2));
        System.out.println(getTheResult(numberThree, k3));
        System.out.println(monotonicallyStack(numberThree, k3));
        System.out.println(doubleEndedQueue(numberThree, k3));
    }

    /**
     * 贪心+双端队列，避免栈的依次弹出反转
     *
     * @param num String
     * @param k   int
     * @return String
     */
    public static String doubleEndedQueue(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean loadingZero = true;
        while (!deque.isEmpty()) {
            Character digit = deque.pollFirst();
            if (loadingZero && digit == '0') {
                continue;
            }
            loadingZero = false;
            stringBuilder.append(digit);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    /**
     * 单调栈+贪心
     *
     * @param num String
     * @param k   int
     * @return String
     */
    public static String monotonicallyStack(String num, int k) {
        int len = num.length();
        Stack<Character> elementStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char element = num.charAt(i);
            while (!elementStack.empty() && k > 0 && elementStack.peek() > element) {
                elementStack.pop();
                k--;
            }
            elementStack.push(element);
        }

        /**
         * 弹出超过长度的元素
         */
        for (int i = 0; i < k; i++) {
            elementStack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = elementStack.size();
        for (int i = 0; i < length; i++) {
            Character pop = elementStack.pop();
            if (i == length - 1 && pop == '0') {
                continue;
            }
            stringBuilder.insert(0, pop);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    /**
     * 需要删除的元素个数与存在的元素个数之和应该等于原字符串的长度,移动窗口找最小的值，如果最后还未满足新字符串长度 则截取
     *
     * @param num String
     * @param k   int
     * @return int
     */
    public static String getTheResult(String num, int k) {
        char[] array = num.toCharArray();
        int len = array.length;
        if (k == len) {
            return "0";
        }
        int digit = len - k;
        int resultLength = 0;
        String result = "";
        while (digit < len) {
            int min = 10;
            for (int i = resultLength; i < digit; i++) {
                min = Math.min(min, array[i] - '0');
            }
            result += min;
            digit++;
            resultLength++;
        }
        if (k + resultLength < len) {
            if (result.startsWith("0")) {
                result = result.replaceFirst("0", "");
            }
            result += num.substring(k + resultLength, len);
        }
        return result;
    }
}
