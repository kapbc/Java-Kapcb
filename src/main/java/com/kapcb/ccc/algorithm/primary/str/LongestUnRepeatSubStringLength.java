package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: L </a>
 * <a>Description: LongestUnRepeatSubStringLength <a>
 *
 * @version 1.0
 * @date 2022/9/10 8:39
 * @since 1.0
 */
public class LongestUnRepeatSubStringLength {

    /**
     * 美团面试:
     * 给定一个只由小写字母(a ~ z)组成的字符串str,
     * 返回其中最长无重复字符的子串长度
     *
     * @param args {@link String[]}
     */
    public static void main(String[] args) {
        String randomString = getRandomString(5, 15);
        System.out.println("randomString = " + randomString);
        int i = longestLength(randomString);
        System.out.println("i = " + i);
    }

    private static int longestLength(String s) {

        // 边界条件判断
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 字符串转换为char[]
        char[] chars = s.toCharArray();

        int n = chars.length;

        int[] last = new int[26];

        // 记录26个字母分别的最大无重复字串
        // last[0] -> a 上次出现的位置
        // last[1] -> b 上次出现的位置
        // last[2] -> c 上次出现的位置
        // ...
        // last[25] -> z 上次出现的位置
        for (int i = 0; i < 26; i++) {
            // 为所有字符赋初始值 -1
            last[i] = -1;
        }

        // 将字符串中第一个字符出现的位置置为 0
        last[chars[0] - 'a'] = 0;

        // 记录最长无重复字符字串的长度
        int max = 1;
        // 记录当前字符前一个字符的最长无重复字符字串的长度
        int prevMaxLen = 1;

        // 从 1 开始, 因为字符串中第一个字符出现的位置一定是 0
        for (int i = 1; i < n; i++) {
            // i - last[chars[i] - 'a'] -> 代表当前字符出现的位置 - 当前字符上一次出现的位置 = 当前位置元素的最长无重复字符字串长度
            // prevMaxLen + 1 -> 代表当前字符前面的一个字符的最大无重复字符字串的长度在加上当前字符串的长度
            // 谁小谁就是当前字符的最大无重复字符字串的长度
            prevMaxLen = Math.min(i - last[chars[i] - 'a'], prevMaxLen + 1);
            // 当前字符的无重复字符字串与前面所有的字符的无重复字符字串的最大长度比较，谁大谁就是当前的最大无重复字符字串长度
            max = Math.max(max, prevMaxLen);
            // 更新 last[] 中当前字符上次出现的位置为当前位置
            last[chars[i] - 'a'] = i;
        }

        return max;
    }

    private static String getRandomString(int possibilities, int maxSize) {
        char[] chars = new char[(int) (Math.random() * maxSize + 1)];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(chars);
    }

}
