package com.kapcb.ccc.leetcode;

import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * <a>Title:SortArrayByParity </a>
 * <a>Author：kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/12 8:44
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * link: https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParity {

    private static final Logger logger = Logger.getLogger(String.valueOf(SortArrayByParity.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {
        int[] array = {4, 2, 5, 7};
//        List<Integer> sortArrayByParity = getSortArrayByParityNotRecommended(array);
//        System.out.println(sortArrayByParity);

        int[] sortArrayByParity = getSortArrayByParity(array);
        System.out.println(Arrays.toString(sortArrayByParity));
    }

    /**
     * 两次遍历，先找 index 为偶数的，再找index为奇数的
     *
     * @param array int[]
     * @return List<Integer>
     */
    private static int[] getSortArrayByParity(int[] array) {
        if (array.length % 2 != 0 || array.length < 2 || array.length > 20000) {
            logger.warning("leetcode.error.message");
            return null;
        }
        Arrays.sort(array);
        if (array[0] < 0) {
            logger.warning("leetcode.error.message");
            return null;
        }
        int len = array.length;
        int[] result = new int[len];
        int indexForEven = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                result[indexForEven] = i;
                indexForEven += 2;
            }
        }

        int indexForOdd = 1;
        for (int i : array) {
            if (i % 2 != 0) {
                result[indexForOdd] = i;
                indexForOdd += 2;
            }
        }
        return result;
    }

    /**
     * Not Recommended
     * 分别拿到奇数和偶数，然后间隔放入
     *
     * @param array int[]
     * @return List<Integer>
     */
    private static List<Integer> getSortArrayByParityNotRecommended(int[] array) {
        if (array.length % 2 != 0 || array.length < 2 || array.length > 20000) {
            logger.warning("leetcode.error.message");
            return null;
        }
        Arrays.sort(array);
        if (array[0] < 0) {
            logger.warning("leetcode.error.message");
            return null;
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenList.add(array[i]);
            } else {
                oddList.add(array[i]);
            }
        }
        boolean flag = true;
        int len = array.length;
        int indexForEven = 0;
        int indexForOdd = 0;
        while ((indexForEven + indexForOdd) < len) {
            if (flag) {
                result.add(evenList.get(indexForEven));
                indexForEven++;
                flag = false;
                continue;
            }
            if (!flag) {
                result.add(oddList.get(indexForOdd));
                indexForOdd++;
                flag = true;
                continue;
            }
        }
        return result;
    }
}
