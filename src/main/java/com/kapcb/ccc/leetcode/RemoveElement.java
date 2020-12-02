package com.kapcb.ccc.leetcode;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * <a>Title: RemoveElement </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/2-9:23
 * <p>
 * link: https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {
    private static final Logger logger = Logger.getLogger(String.valueOf(RemoveElement.class), "logmessage_en");

    public static void main(String[] args) {
        int[] testArrayOne = {3, 2, 2, 3};
        int targetOne = 3;
        int[] testArrayTwo = {0, 1, 2, 2, 3, 0, 4, 2};
        int targetTwo = 2;
        int result = removeElement(testArrayOne, targetOne);
        System.out.println("result = " + result);
        int i = removeElement(testArrayTwo, targetTwo);
        System.out.println("i = " + i);

        logger.warning("kapcb.test.dividing.line");

        int theElement = removeTheElement(testArrayOne, targetOne);
        System.out.println("theElement = " + theElement);
        int element = removeTheElement(testArrayTwo, targetTwo);
        System.out.println("element = " + element);

        logger.warning("kapcb.test.dividing.line");

        int elementToLast = removeTheElementToLast(testArrayOne, targetOne);
        System.out.println("elementToLast = " + elementToLast);
        int removeTheElementToLast = removeTheElementToLast(testArrayTwo, targetTwo);
        System.out.println("removeTheElementToLast = " + removeTheElementToLast);
    }

    /**
     * 双指针，将寻找的目标元素替换到数组最后，并更新数组的实时长度
     *
     * @param array  int[]
     * @param target int
     * @return int
     */
    private static int removeTheElementToLast(int[] array, int target) {
        int len = array.length;
        int index = 0;
        while (index < len) {
            if (array[index] == target) {
                array[index] = array[len - 1];
                len--;
            } else {
                index++;
            }
        }
        return index;
    }

    /**
     * 将非目标元素重新赋值给原数组。 双指针
     *
     * @param array  int[]
     * @param target int
     * @return int
     */
    private static int removeTheElement(int[] array, int target) {
        int len = array.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] != target) {
                array[index] = array[i];
                index++;
            }
        }
        return index;
    }

    /**
     * 将目标元素移动至数组最后
     *
     * @param array  int[]
     * @param target int
     * @return int
     */
    private static int removeElement(int[] array, int target) {
        int len = array.length;
        int result = 0;
        int index = 0;
        for (int j = 0; j < len; j++) {
            index = j;
            while (index < len && array[j] == target) {
                int temp = 0;
                if (array[index] != target) {
                    result = j;
                    temp = array[j];
                    array[j] = array[index];
                    array[index] = temp;
                    break;
                }
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
        return result + 1;
    }
}
