package com.kapcb.ccc.leetcode;


/**
 * <a>Title:CountAndSay</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/12/2 21:10
 * <p>
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * link: https://leetcode-cn.com/problems/count-and-say/
 */
public class CountAndSay {

    private static final int STEP = 1;

    public static void main(String[] args) {

        /**
         * 双指针
         */
        System.out.println(countAndSay(5));

        /**
         * 递归调用
         */
        System.out.println(countAndSayByDeliverTortoise(5 + STEP));
    }

    /**
     * 双指针，慢指针指向第一个元素，块指针指向第一个与块指针所指向元素不同的元素，所以当前元素出现次数为 (快指针索引- 慢指针索引) 然后拼接上慢指针所指向的当前元素，最后将
     * 快指针赋值给慢指针。然后循环上述即可
     *
     * @param n int
     * @return String
     */
    private static String countAndSay(int n) {
        StringBuilder current = new StringBuilder("1");
        StringBuilder previous = new StringBuilder("1");
        for (int i = 0; i < n; i++) {
            previous = current;
            current = new StringBuilder();
            int start = 0;
            int end = 0;
            /**
             * 遍历前一项
             */
            while (end < previous.length()) {
                while (end < previous.length() && previous.charAt(start) == previous.charAt(end)) {
                    end++;
                }

                /**
                 * 元素出现次数与元素进行拼接
                 */
                current = current.append(String.valueOf(end - start)).append(previous.charAt(start));
                start = end;
            }
        }
        return current.toString();
    }

    /**
     * 双指针递归
     *
     * @param n int
     * @return String
     */
    public static String countAndSayByDeliverTortoise(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuilder result = new StringBuilder();

        // 拿到上一层的字符串
        String previous = countAndSayByDeliverTortoise(n - 1);
        int length = previous.length();
        // 开始指针为0
        int start = 0;
        for (int i = 1; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                result.append(i - start).append(previous.charAt(start));
            }
            // 直到start位的字符串和i位的字符串不同，拼接并更新start指针位置
            else if (previous.charAt(i) != previous.charAt(start)) {
                result.append(i - start).append(previous.charAt(start));
                start = i;
            }
        }
        return result.toString();
    }
}
