package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: ZTransformation </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Z字形变换 <a>
 * https://leetcode.cn/problems/zigzag-conversion/
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/24 11:36 PM
 * @since 1.0
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        int i = 4 / 14;
        System.out.println("i = " + i);
        int i1 = 8 / 14;
        System.out.println("i1 = " + i1);
        int i2 = 12 / 14;
        System.out.println("i2 = " + i2);
        int i3 = 16 / 14;
        System.out.println("i3 = " + i3);
        int i4 = 20 / 14;
        System.out.println("i4 = " + i4);

        int i5 = 4 % 14;
        System.out.println("i5 = " + i5);

        String res = convert("PAYPALISHIRING", 3);
        System.out.println("res = " + res);
    }

    private static String convert(String s, int numRows) {

        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();

    }
}
