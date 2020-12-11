package com.kapcb.ccc.algorithm.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title:Interval</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * link: https://leetcode-cn.com/problems/insert-interval/
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/11/4 19:20
 */
public class Interval {

    private Interval() {
    }

    public static void main(String[] args) {
        int[][] interval = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] interval1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};

        List<int[]> intervalResult = getIntervalResult(interval, newInterval);
        for (int[] ints : intervalResult) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static List<int[]> getIntervalResult(int[][] interval, int[] newInterval) {

        int leftIndex = newInterval[0];
        int rightIndex = newInterval[1];
        boolean flag = false;
        List<int[]> elementList = new ArrayList<>();
        for (int[] ints : interval) {
            if (ints[0] > rightIndex) {
                if (!flag) {
                    elementList.add(new int[]{leftIndex, rightIndex});
                    flag = true;
                }
                elementList.add(ints);
            } else if (ints[1] < leftIndex) {
                elementList.add(ints);
            } else {
                leftIndex = Math.min(leftIndex, ints[0]);
                rightIndex = Math.max(rightIndex, ints[1]);
            }
        }
        if (!flag) {
            elementList.add(new int[]{leftIndex, rightIndex});
        }
        return elementList;
    }
}

