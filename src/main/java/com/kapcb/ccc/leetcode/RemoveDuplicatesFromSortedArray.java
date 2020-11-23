package com.kapcb.ccc.leetcode;

/**
 * <a>Title: RemoveDuplicatesFromSortedArray </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/23-10:23
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4]
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(array);
        System.out.println(len);
        System.out.println("========array result========");
        for (int i = 0; i < len; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 将非重复元素移动到数组左侧
     *
     * @param array int[]
     * @return int
     */
    private static int removeDuplicates(int[] array) {
        int indexSlow = 0;
        int indexQuick = 1;
        while (indexQuick < array.length) {
            if (array[indexSlow] != array[indexQuick]) {
                if (indexQuick - indexSlow > 1) {
                    array[indexSlow + 1] = array[indexQuick];
                }
                indexSlow++;
            }
            indexQuick++;
        }
        return indexSlow + 1;
    }
}
