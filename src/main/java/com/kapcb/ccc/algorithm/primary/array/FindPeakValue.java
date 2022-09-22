package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: FindPeakValue </a>
 * <a>Author: Kapcb <a>
 * <a>Description: 寻找峰值 <a>
 * <a href="https://www.nowcoder.com/practice/fcf87540c4f347bcb4cf720b5b350c76?tpId=295&tqId=2227748&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/22 22:17
 * @since 1.0
 */
public class FindPeakValue {

    public static void main(String[] args) {
        int[] nums = {8, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int peakElement = findPeakElement(nums);
        System.out.println("peakElement = " + peakElement);
    }

    public static int findPeakElement(int[] nums) {
        // write code here

        if (nums == null) {
            return -1;
        }

        if (nums.length < 2 || nums[0] > nums[1]) {
            return 0;
        }

        int n = nums.length - 1;

        if (nums[n] > nums[n - 1]) {
            return n - 1;
        }

        int l = 0;
        int r = n;

        while (l < (r - 1)) {
            int mid = l + ((r - l) >> 1);

            // 左 < mid > 右
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                // 左 < mid mid < 右
                // 左 > mid > 右
                // 左 > mid mid < 右边
                if (nums[mid - 1] < nums[mid]) {
                    l = mid - 1;
                } else {
                    r = mid + 1;
                }
            }
        }

        return nums[l] > nums[r] ? l : r;

    }

}
