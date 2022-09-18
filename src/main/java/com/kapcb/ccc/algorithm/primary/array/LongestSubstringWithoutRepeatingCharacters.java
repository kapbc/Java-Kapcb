package com.kapcb.ccc.algorithm.leetcode.junior;

/**
 * <a>Title: LongestSubstringWithoutRepeatingCharacters </a>
 * <a>Description: LongestSubstringWithoutRepeatingCharacters <a>
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">...</a>
 *
 * @version 1.0
 * @date 2022/8/30 9:31
 * @since 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }

    public static int lengthOfLongestSubstring(String s) {

        // 边界条件判断
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        return 0;


    }

    private static void selectionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int minValueIndex = 0;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = nums[minValueIndex] > nums[j] ? j : minValueIndex;
            }
            if (i != minValueIndex) {
                swap(nums, i, minValueIndex);
            }
        }

    }

    private static void bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void insertionSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        for (int j = 1; j < n; j++) {
            for (int i = j; i >= 0 && nums[i - 1] > nums[i]; i--) {
                swap(nums, i - 1, i);
            }
        }

    }

    private static void swap(int[] nums, int l, int r) {
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }

}
