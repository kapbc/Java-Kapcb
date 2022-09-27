package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: ContainerWithMostWater </a>
 * <a>Author: kapcb <a>
 * <a>Description: 盛最多水的容器 <a>
 * <a href="https://leetcode-cn.com/problems/container-with-most-water/">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/27 20:59
 * @since 1.0
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxArea(array);
        System.out.println("res = " + res);

        int res1 = maxArea1(array);
        System.out.println("res1 = " + res1);
    }

    /**
     * 双指针
     * l指针从数组左边开始，r指针从数组右边开始
     * 时间复杂度O(n)
     *
     * @param height int[]
     * @return int
     */
    private static int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = height[l] < height[r] ? Math.max(max, (r - l) * height[l++]) : Math.max(max, (r - l) * height[r--]);
        }

        return max;
    }

    private static int maxArea1(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int p = i + 1;
            while (p < n) {
                max = Math.max(max, Math.min(height[i], height[p]) * (p - i));
                p++;
            }
        }

        return max;
    }

}
