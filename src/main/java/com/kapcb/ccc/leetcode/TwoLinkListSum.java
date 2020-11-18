package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname TwoLinkListSum
 * @date 2020/11/4 16:19
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * link: https://leetcode-cn.com/problems/add-two-numbers/
 */
public class TwoLinkListSum {

    public static void main(String[] args) {

        List<Integer> integers = new LinkedList<>();
        List<Integer> integers2 = new LinkedList<>();
        integers.add(2);
        integers.add(4);
        integers.add(6);
        integers2.add(5);
        integers2.add(5);
        integers2.add(4);
        List<Integer> twoLinkListSum = getTwoLinkListSum(integers, integers2);
        System.out.println(twoLinkListSum);
    }

    /**
     * @param elementOne List<Integer>
     * @param elementTwo List<Integer>
     * @return List<Integer>
     */
    public static List<Integer> getTwoLinkListSum(List<Integer> elementOne, List<Integer> elementTwo) {
        List<Integer> result = new LinkedList<>();
        List<Integer> resultForReverse = new LinkedList<>();
        ListIterator<Integer> elementOneIterator = elementOne.listIterator();
        ListIterator<Integer> elementTwoIterator = elementTwo.listIterator();
        int loopCount = Math.max(elementOne.size(), elementTwo.size());
        int carry = 0;
        for (int i = 0; i < loopCount; i++) {
            Integer resultOne = 0;
            Integer resultTwo = 0;
            if (elementOneIterator.hasNext()) {
                resultOne = elementOneIterator.next();
            }
            if (elementTwoIterator.hasNext()) {
                resultTwo = elementTwoIterator.next();
            }
            int resultNum = resultOne + resultTwo + carry;
            result.add(resultNum % 10);
            carry = resultNum / 10;
        }
        if (carry > 0) {
            result.add(carry);
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            resultForReverse.add(result.get(i));
        }
        return resultForReverse;

    }

    /**
     * Not Recommended and that method have some trouble
     *
     * @param elementOne List<Integer>
     * @param elementTwo List<Integer>
     * @return List<Integer>
     */
    private static List<Integer> getTwoLinkListSumNotRecommended(List<Integer> elementOne, List<Integer> elementTwo) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(elementOne);
        array.add(elementTwo);
        Integer number = 0;
        for (List<Integer> element : array) {
            String num = "";
            Iterator<Integer> iterator = element.iterator();
            while (iterator.hasNext()) {
                String next = String.valueOf(iterator.next());
                num += next;
            }
            String s = new StringBuffer(num).reverse().toString();
            Integer.valueOf(s);
            number += Integer.valueOf(s);
        }
        String result = new StringBuffer(String.valueOf(number)).reverse().toString();
        String[] split = result.split("");
        List<Integer> elementList = new LinkedList<>();
        for (String s : split) {
            elementList.add(Integer.valueOf(s));
        }
        return elementList;
    }
}
