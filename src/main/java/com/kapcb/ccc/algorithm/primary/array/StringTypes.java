package com.kapcb.ccc.algorithm.primary.str;

import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: StringTypes </a>
 * <a>Description: StringTypes <a>
 *
 * @version 1.0
 * @date 2022/9/10 10:15
 * @since 1.0
 */
public class StringTypes {

    /**
     * 快手一面：
     * 如果两个字符串，所含字符种类完全一样，就算做一类只由小写字母（a ~ z）
     * 组成的一批字符串，都放在字符串类型的数组String[] arr中，返回arr中一共
     * 有多少个类。
     * 示例：
     * 输入：abcgafdefg
     * 输出：abcdefg
     *
     * @param args {@link String[]}
     */
    public static void main(String[] args) {
        int i = type1(new String[]{"abcgafdefg"});
        System.out.println("i = " + i);
    }

    private static int type1(String[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        // 不同类的摘要，都存放在types中
        Set<String> types = new HashSet<>();

        for (String str : arr) {

            char[] chars = str.toCharArray();

            boolean[] map = new boolean[26];

            for (char aChar : chars) {

                // 将字符产中所有出现过的字符记录为true
                map[aChar - 'a'] = true;

            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (map[i]) {
                    sb.append(String.valueOf((char) (i + 'a')));
                }
            }

            types.add(sb.toString());

        }
        return types.size();
    }

    private static int types(String[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        // 使用 int 数字代表一种类型
        Set<Integer> types = new HashSet<>();

        for (String str : arr) {

            char[] chars = str.toCharArray();

            int key = 0;

            for (char aChar : chars) {
                // 使用 int 的 32 进制位中的 26 个位记录字符类型
                key |= (1 << (aChar - 'a'));
            }

            types.add(key);
        }

        return types.size();

    }

}
