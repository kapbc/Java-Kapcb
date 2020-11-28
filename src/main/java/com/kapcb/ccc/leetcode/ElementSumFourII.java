package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: ElementSumFourII </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/27 - 22:42
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 *
 * <p>
 * link: https://leetcode-cn.com/problems/4sum-ii/
 */
public class ElementSumFourII {
    public static void main(String[] args) {

        int[] arrayA = {1, 2};
        int[] arrayB = {-2, -1};
        int[] arrayC = {-1, 2};
        int[] arrayD = {0, 2};

        int i = fourSumCount(arrayA, arrayB, arrayC, arrayD);
        System.out.println("i = " + i);
    }

    private static int fourSumCount(int[] arrayA, int[] arrayB, int[] arrayC, int[] arrayD) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        Arrays.sort(arrayC);
        Arrays.sort(arrayD);
        int len = arrayA.length;
        int leftIndex;
        int rightIndex;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elementList;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boolean flag = false;
                elementList = new ArrayList<>();
                leftIndex = 0;
                rightIndex = len - 1;
                while (0 <= rightIndex && leftIndex < len && arrayA[leftIndex] + arrayB[i] + arrayC[j] + arrayD[rightIndex] > 0) {
                    if (arrayA[leftIndex] + arrayB[i] + arrayC[j] + arrayD[rightIndex] == 0) {
                        elementList.add(leftIndex);
                        elementList.add(i);
                        elementList.add(j);
                        elementList.add(rightIndex);
                        flag = true;
                        break;
                    }
                    rightIndex--;
                }
                while (0 <= rightIndex && leftIndex < len && arrayA[leftIndex] + arrayB[i] + arrayC[j] + arrayD[rightIndex] < 0) {
                    if (arrayA[leftIndex] + arrayB[i] + arrayC[j] + arrayD[rightIndex] == 0) {
                        elementList.add(leftIndex);
                        elementList.add(i);
                        elementList.add(j);
                        elementList.add(rightIndex);
                        flag = true;
                        break;
                    }
                    leftIndex++;
                }
                if (0 <= rightIndex && leftIndex < len && arrayA[leftIndex] + arrayB[i] + arrayC[j] + arrayD[rightIndex] == 0) {
                    elementList.add(leftIndex);
                    elementList.add(i);
                    elementList.add(j);
                    elementList.add(rightIndex);
                    flag = true;
                }
                if (flag) {
                    result.add(elementList);
                }
            }
        }
        System.out.println(result);
        return result.size();
    }
}
