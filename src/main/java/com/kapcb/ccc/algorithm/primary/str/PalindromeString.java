package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: PalindromeString </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PalindromeString <a>
 * <a href="https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2?tpId=295&tqId=1089616&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/19 9:42 PM
 * @since 1.0
 */
public class PalindromeString {

    public static void main(String[] args) {
        String str = "ababb";
        boolean judge = judge(str);
        System.out.println("judge = " + judge);
    }

    private static boolean judge(String str) {
        // write code here

        if (str == null || str.length() == 0) {
            return false;
        }

        if (str.length() < 2) {
            return true;
        }

        char[] strArray = str.toCharArray();

        int l = 0;
        int r = strArray.length - 1;

        while (l < r) {
            if (strArray[l++] != strArray[r--]) {
                return false;
            }
        }

        return true;

    }

}
