package com.kapcb.ccc.algorithm.primary.array;

/**
 * <a>Title: RangeSum </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RangeSum <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/14 9:56 PM
 * @since 1.0
 */
public class RangeSum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        PrefixSum prefixSum = new PrefixSum(arr);
        int result = prefixSum.calSum(1, 4);
        System.out.println("result = " + result);

    }


    private static class PrefixSum {

        private int[] preSum;

        // 利用前缀和, 快速返回数组r下标到l下标之间的和
        public PrefixSum(int[] arr) {

            int n = arr.length;
            this.preSum = new int[n];

            preSum[0] = arr[0];

            for (int i = 1; i < n; i++) {
                this.preSum[i] = arr[i] + preSum[i - 1];
            }

        }

        public int calSum(int l, int r) {
            return l == 0 ? preSum[r] : preSum[r] - preSum[l - 1];
        }

    }

}
