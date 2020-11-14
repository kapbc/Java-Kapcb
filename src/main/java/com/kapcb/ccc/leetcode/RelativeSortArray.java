package com.kapcb.ccc.leetcode;


import java.util.*;

/**
 * <a>Title:RelativeSortArray</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/11/14 20:38
 * 给你两个数组，arr1 和 arr2
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * link: https://leetcode-cn.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] array1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] array2 = {2, 1, 4, 3, 9, 6};

        int[] relativeSortArray = getRelativeSortArray(array1, array2);
        System.out.println(Arrays.toString(relativeSortArray));
    }

    /**
     * 在map中存在的元素的索引都是一样的，所以索引相同的元素排序后都是相等，在map中不存在的元素直接进行大小比较
     *
     * @param array1 int[]
     * @param array2 int[]
     * @return int[]
     */
    private static int[] getRelativeSortArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length];
        Map<Integer, Integer> map = new HashMap<>(6);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            map.put(array2[i], i);
        }
        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * Not Recommended
     * <p>
     * 双层循环遍历，还可使用hashmap记录array2中元素在array中出现的次数，然后按照array2的顺序进行添加到结果数组中
     * 总感觉这样有点low，有更好的方法会更新
     *
     * @param array1 int[]
     * @param array2 int[]
     * @return int[]
     */
    private static int[] getRelativeSortArrayNotRecommended(int[] array1, int[] array2) {
        int len = array1.length;
        int[] result = new int[len];
        int index = 0;
        Arrays.sort(array1);
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array1[j] == array2[i]) {
                    result[index] = array1[j];
                    array1[j] = 0;
                    index++;
                }
            }
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != 0) {
                result[index] = array1[i];
                index++;
            }
        }
        return result;
    }
}
