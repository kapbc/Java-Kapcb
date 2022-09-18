package com.kapcb.ccc.algorithm.primary.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * <a>Title: TwoNumOnlyAppearOnce </a>
 * <a>Description: TwoNumOnlyAppearOnce <a>
 * <a href="https://www.nowcoder.com/practice/389fc1c3d3be4479a154f63f495abff8?tpId=295&tqId=1375231&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/15 16:51
 * @since 1.0
 */
public class TwoNumOnlyAppearOnce {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 2, 9};
        int[] numsAppearOnce = findNumsAppearOnce(array);
        System.out.println(Arrays.toString(numsAppearOnce));

        int[] array1 = {1, 2, 3, 3, 2, 9};
        int[] numsAppearOnce1 = findNumsAppearOnce1(array1);
        System.out.println(Arrays.toString(numsAppearOnce1));
    }

    /**
     * 借助TreeSet
     *
     * @param array {@link int[]}
     * @return {@link int[]}
     */
    private static int[] findNumsAppearOnce(int[] array) {
        // write code here
        if (array == null || array.length < 2) {
            return array;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int j : array) {
            if (!set.add(j)) {
                set.remove(j);
            }
        }

        int[] res = new int[set.size()];
        int index = 0;
        for (Integer val : set) {
            res[index] = val;
            index++;
        }

        return res;
    }

    private static int[] findNumsAppearOnce1(int[] array) {

        if (array == null || array.length < 2) {
            return array;
        }
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }

        int rightOne = xor & (~xor + 1);
        int onlyOne = 0;
        for (int cur : array) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        return onlyOne < (onlyOne ^ xor) ? new int[]{onlyOne, onlyOne ^ xor} : new int[]{onlyOne ^ xor, onlyOne};

    }

}
