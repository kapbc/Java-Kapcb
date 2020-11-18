package com.kapcb.ccc.leetcode;

/**
 * <a>Title: GasStation </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-16:33
 * <p>
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * link: https://leetcode-cn.com/problems/gas-station/
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        calculator(gas, cost);
    }

    private static int calculator(int[] gas, int[] cost) {
        int carGas = 0;
        int costGas = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            costGas = gas[i] - cost[i];
            if (costGas > 0) {
                index = i;
                while (index != index - 1) {
                    costGas
                }
            }

        }
        return -1;
    }
}
