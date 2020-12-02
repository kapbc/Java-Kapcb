package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {

        countAndSay(5);
    }

    private static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1211");
        digui(sb);
        return null;
    }

    private static void digui(StringBuilder stringBuilder) {
        String s = stringBuilder.toString();
        char[] chars = s.toCharArray();
        String result = null;
        for (int i = 0; i < chars.length; i++) {
            int index = 1;
            if (chars[i] == chars[i + 1]) {
                while (i <= chars.length - 1 && index < chars.length) {
                    if (chars[index] != chars[i]) {
                        break;
                    }
                    index++;
                }
                i = index - 1;
            }
            result = String.valueOf(index) + chars[i];
            System.out.println("index = " + index);
        }
    }
}
