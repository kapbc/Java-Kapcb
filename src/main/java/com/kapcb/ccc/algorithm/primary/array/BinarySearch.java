package com.kapcb.ccc.algorithm.leetcode.junior;

/**
 * <a>Title: BinarySearch </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BinarySearch <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/8/22 9:28 PM
 * @since 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int rank = rank(9, a, 0, a.length - 1);
        System.out.println("rank = " + rank);
    }

    /**
     * 查找的前提是待查找序列是升序的。
     * 算法流程：
     * a.使用目标元素与样本数列(升序)中的中间元素比较大小，若相等则表示查找成功；
     * b.若目标元素小于中间元素，则应该去中间元素的左边进行查找；
     * c.若目标元素大于中间元素，则应该去中间元素的右边进行查找；
     * d.重复步骤a，直到比较完毕所有该比较元素也没有相等的元素，则表示查找失败；
     *
     * @param key  目标元素
     * @param nums 升序数组
     * @param low  左指针
     * @param high 右指针
     * @return 元素下标
     */
    private static int rank(int key, int[] nums, int low, int high) {

        // 边界条件判断
        if (low > high) {
            return -1;
        }

        // 计算中点mid，避免数值越界
        int mid = low + ((high - low) >> 1);

        // 若中间元素等于目标元素，则查找成功，返回下标
        if (key == nums[mid]) {
            return mid;
        }

        // 若目标元素大于中间元素，则在中间元素的右边查找，重复以上步骤，使用递归实现
        // 如果中点值大于查找值, 则查找值存在于[low ,mid-1)区间中
        if (key < nums[mid]) {
            return rank(key, nums, low, --mid);
        }

        // 若目标元素小于中间元素，则在中间元素的左边查找，重复以上步骤，使用递归实现
        // 如果中点值小于查找值, 则查找值存在于(low+1 ,high]区间中
        return rank(key, nums, ++low, high);

    }

}
