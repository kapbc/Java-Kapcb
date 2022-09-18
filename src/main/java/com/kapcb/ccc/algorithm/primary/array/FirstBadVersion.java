package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: FirstBadVersion </a>
 * <a>Description: FirstBadVersion <a>
 * <a href="https://leetcode.cn/problems/first-bad-version/">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/8/26 12:07
 * @since 1.0
 */
public class FirstBadVersion {

    private static final int BAD_VERSION = 4;

    public static void main(String[] args) {
        int i = foundFirstBadVersion(5);
        System.out.println("i = " + i);
    }

    /**
     * 寻找第一个错误的版本
     *
     * @param n int
     * @return int
     */
    private static int foundFirstBadVersion(int n) {
        // 左指针
        int left = 1;
        // 右指针
        int right = n;

        while (left < right) {

            // 获取中点
            int mid = left + ((right - left) >> 1);

            // 如果中点是错误版本, 则第一个错误的版本在[left, mid]区间
            if (isBadVersion(mid)) {
                // 将右指针移动到中点位置
                right = mid;
            } else {
                // 如果中点不是错误版本, 则第一个错误的版本在[mid+1, right]区间
                // 将左指针移动到 mid+1 的位置
                left = ++mid;
            }

        }
        // 返回第一个错误的版本位置
        return left;
    }

    private static boolean isBadVersion(int version) {
        return version >= BAD_VERSION;
    }
}
