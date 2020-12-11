package com.kapcb.ccc.algorithm.leetcode.secondary;


/**
 * <a>Title: ContainerWithMostWater </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/12-16:11
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 * <p>
 * link: https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] testArray = {4, 3, 2, 1, 4};
        int[] testArray1 = {1, 2, 1};
        int containerWithMostWater = getContainerWithMostWater(testArray1);
        System.out.println(containerWithMostWater);
    }

    /**
     * 双指针，一层循环遍历，先固定一个值，然后依次计算面积
     *
     * @param array int[]
     * @return int
     */
    private static int getContainerWithMostWater(int[] array) {
        int len = array.length;
        int area = 0;
        for (int i = 0; i < len; i++) {
            int rightIndex = len - 1;
            while (i < rightIndex) {
                area = Math.max(area, (Math.min(array[i], array[rightIndex])) * (rightIndex - i));
                rightIndex--;
            }
        }
        return area;
    }
}
