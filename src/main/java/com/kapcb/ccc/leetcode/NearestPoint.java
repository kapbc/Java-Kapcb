package com.kapcb.ccc.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname NearestPoint
 * @date 2020/11/9 11:13
 * <p>
 * 有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。（这里，平面上两点之间的距离是欧几里德距离。）
 * 可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * link: https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class NearestPoint {
    public static void main(String[] args) {
        double[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        double[][] point = {{1, 3}, {-2, 2}};
        int k1 = 1;
        int k = 2;
        double[][] nearestPoint = getNearestPoint(point, k1);
        for (double[] result : nearestPoint) {
            System.out.println(Arrays.toString(result));
        }
    }

    private static double[][] getNearestPoint(double[][] array, int k) {
        Comparator<double[]> comparator = Comparator.comparingDouble(o -> Math.sqrt(getResult(o)));
        Arrays.sort(array, comparator);
        double[][] doubles = Arrays.copyOf(array, k);
        return doubles;
    }

    private static double getResult(double[] array) {
        return (Math.pow(array[0], 2) + Math.pow(array[1], 2));
    }
}
