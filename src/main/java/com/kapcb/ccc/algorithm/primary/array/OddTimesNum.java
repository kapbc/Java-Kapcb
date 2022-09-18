package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: OddTimesNum </a>
 * <a>Author: Kapcb <a>
 * <a>Description: OddTimesNum <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/2/20 16:59
 * @since 1.0
 */
public class OddTimesNum {

    private OddTimesNum() {
    }

    /**
     * 数组nums中出现了两类数, 其中一类数出现了奇数次,
     * 另外一类数出现了偶数次, 请输出出现奇数次的数字
     * <p>
     * 时间复杂度 O(n)
     */
    private static void doOddTimesNum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        System.out.println(xor);
    }

    /**
     * 数组中有两类数出现了奇数次, 其它数都出现偶初次, 请输出
     * 出现奇数次的数字。
     *
     * @param nums int[]
     */
    private static void doOddTimesNum2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightOne = xor & (~xor + 1);
        int onlyOne = 0;
        for (int cur : nums) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + ", " + (xor ^ onlyOne));
    }

    public static void main(String[] args) {
        // 2
        int[] nums = new int[]{2, 1, 6, 1, 3, 2, 1, 6, 3, 2, 1, 2, 2};
        doOddTimesNum(nums);

        // 1、3
        int[] numsOne = new int[]{1, 8, 2, 6, 3, 6, 3, 6, 1, 2, 6, 3, 8, 1};
        doOddTimesNum2(nums);
    }

}
