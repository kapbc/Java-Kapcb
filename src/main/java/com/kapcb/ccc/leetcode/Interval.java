package com.kapcb.ccc.leetcode;


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

    public static void main(String[] args) {
        int[][] interval = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] interval1 = {{1,3}, {6,9}};
        int[] newInterval1 = {2, 5};

        List<int[]> intervalResult = getIntervalResult(interval1, newInterval1);
        for (int[] ints : intervalResult) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static List<int[]> getIntervalResult(int[][] interval, int[] newInterval) {

        int len = interval.length;
        int index = 0;
        List<int[]> newElement = new ArrayList<>();
        if (newInterval[0] > interval[len - 1][1]) {
            for (int i = 0; i < interval.length; i++) {
                newElement.add(interval[i]);
            }
            newElement.add(newInterval);
        } else if (interval[index][0] > newInterval[1]) {
            newElement.add(newInterval);
            for (int i = 1; i <= interval.length; i++) {
                newElement.add(interval[i]);
            }
        } else {
            while (index < len) {
                if (interval[index][1] < newInterval[0]) {
                    newElement.add(interval[index]);
                    index++;
                } else if (interval[index][1] >= newInterval[0]) {
                    newInterval[0] = Math.min(newInterval[0], interval[index][0]);
                    index++;
                    break;
                }
            }
            while (index < len) {
                if (interval[index][0] < newInterval[1]) {
                    index++;
                } else if (interval[index][0] >= newInterval[1]) {
                    newInterval[1] = Math.max(newInterval[1], interval[index][1]);
                    index++;
                    break;
                }
            }
            System.out.println(Arrays.toString(newInterval));
            newElement.add(newInterval);
        }
        while (index < len) {
            newElement.add(interval[index]);
            index++;
        }
        return newElement;
    }
}

