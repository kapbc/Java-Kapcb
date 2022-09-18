package com.kapcb.ccc.algorithm.primary.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a>Title: FoundElement </a>
 * <a>Description: FoundElement <a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/12 0:42
 * @since 1.0
 */
public class FoundElement {

    /**
     * 今日头条：
     * 数组为{3,2,2,3,1}，查询为(0,3,2)
     * 意思是在数组里下标0~3这个范围上，有几个2？返回2
     * 假设给你一个数组arr，对这个数组的查询非常频繁，请返回所有查询结果
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3, 1};
        QueryBox queryBox = new QueryBox(arr);
        int query = queryBox.query(0, 3, 2);
        System.out.println("query = " + query);

        QueryBox1 queryBox1 = new QueryBox1(arr);
        int query1 = queryBox1.query(0, 3, 2);
        System.out.println("query1 = " + query1);
    }

    /**
     * 暴力破解
     */
    private static class QueryBox {

        private int[] arr;

        public QueryBox(int[] array) {
            arr = new int[array.length];
            System.arraycopy(array, 0, arr, 0, arr.length);
        }

        public int query(int l, int r, int target) {

            int res = 0;
            for (; l <= r; l++) {
                if (arr[l] == target) {
                    res++;
                }
            }

            return res;
        }
    }

    /**
     * 时间复杂度O(n*logn)
     */
    private static class QueryBox1 {

        // key -> int 数组元素
        // value - > int[] 哪些下标上存放的是key
        private HashMap<Integer, List<Integer>> map;

        // 将其转换为图结构，key->元素值，value->元素对应的数组下标
        // 转换后每个key中对应的List<Integer>也是有序的，因为保存的是数组下标
        public QueryBox1(int[] array) {
            int n = array.length;
            map = new HashMap<>(n << 2);
            for (int val : array) {
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<>());
                }
                map.get(val).add(val);
            }

        }

        // 查询[l, r]区间内有多少个target
        public int query(int l, int r, int target) {

            // 如果map中不包含该key，直接返回0
            if (!map.containsKey(target)) {
                return 0;
            }

            List<Integer> indexList = map.get(target);

            // 二分寻找[0, l)上有多少个元素
            int a = countLess(indexList, l);
            // 二分法寻找[0, r+1)上有多少个元素
            int b = countLess(indexList, r + 1);

            // 相减即为中间的元素个数
            return b - a;
        }

        private static int countLess(List<Integer> indexList, int limit) {

            int l = 0;
            int r = indexList.size() - 1;

            int mostRight = -1;

            // 二分
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (indexList.get(mid) < limit) {
                    mostRight = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            // mostRight的初始值为-1
            return mostRight + 1;

        }

    }


}
