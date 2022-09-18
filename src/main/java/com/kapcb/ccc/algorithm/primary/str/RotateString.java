package com.kapcb.ccc.algorithm.primary.str;

/**
 * <a>Title: RotateString </a>
 * <a>Description: RotateString <a>
 *
 * @version 1.0
 * @date 2022/9/12 10:58
 * @since 1.0
 */
public class RotateString {

    /**
     * 给定一个字符串str和长度leftSize，请把str左侧的leftSize部分和右部分
     * 做整体交换。要求额外空间复杂度O(1)。
     * <p>
     * 进阶：如果交换代价很昂贵，有没有更好一些的方法。
     *
     * @param args
     */
    public static void main(String[] args) {

        String s = rotate("abcdef", 2);
        System.out.println("s = " + s);

        String s1 = rotate1("abcdef", 2);
        System.out.println("s1 = " + s1);

        String s2 = rotate2("abcdef", 2);
        System.out.println("s2 = " + s2);

    }

    /**
     * 计算偏移量，时间复杂度O(n)
     *
     * @param str
     * @param leftSize
     * @return
     */
    private static String rotate(String str, int leftSize) {

        if (str == null || str.isEmpty()) {
            return null;
        }

        char[] chars = str.toCharArray();

        int n = chars.length;

        int relativeOffset = leftSize % n;

        if (relativeOffset == 0) {
            return str;
        }

        char[] res = new char[n];

        for (int i = 0; i < n; i++) {
            res[(leftSize + i) % n] = chars[i];
        }

        return String.valueOf(res);
    }

    /**
     * 局部反转字符串并使用辅助空间
     *
     * @param str
     * @param leftSize
     * @return
     */
    private static String rotate1(String str, int leftSize) {

        if (str == null || str.isEmpty()) {
            return null;
        }

        int n = str.length();

        int relativeOffset = leftSize % n;

        if (relativeOffset == 0) {
            return str;
        }

        char[] chars = str.toCharArray();

        reverse(chars, 0, n - relativeOffset - 1);
        reverse(chars, n - relativeOffset, n - 1);
        reverse(chars, 0, n - 1);
        return String.valueOf(chars);
    }

    private static void reverse(char[] charArr, int l, int r) {

        while (l < r) {
            char temp = charArr[l];
            charArr[l++] = charArr[r];
            charArr[r--] = temp;
        }

    }

    /**
     * link : <a href="https://www.bilibili.com/video/BV1vG411n7cc?p=44&vd_source=da0bd8491e466e584387c45d9179ec5e">...</a>
     * @param str
     * @param leftSize
     * @return
     */
    private static String rotate2(String str, int leftSize) {

        if (str == null || str.isEmpty()) {
            return null;
        }

        char[] charArray = str.toCharArray();
        int l = 0;
        int r = charArray.length - 1;
        int lPart = leftSize;
        int rPart = charArray.length - leftSize;
        int same = Math.min(lPart, rPart);
        int diff = lPart - rPart;
        exchange(charArray, l, r, same);

        while (diff != 0) {
            if (diff > 0) {
                l += same;
                lPart = diff;
            } else {
                r -= same;
                rPart = -diff;
            }
            same = Math.min(lPart, rPart);
            diff = lPart - rPart;
            exchange(charArray, l, r, same);
        }

        return String.valueOf(charArray);

    }

    private static void exchange(char[] str, int l, int r, int size) {

        int i = r - size + 1;
        char temp = 0;
        while (size-- != 0) {
            temp = str[l];
            str[l] = str[i];
            str[i] = temp;
            l++;
            i++;
        }
    }

}
