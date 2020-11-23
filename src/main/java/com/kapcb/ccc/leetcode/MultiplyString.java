package com.kapcb.ccc.leetcode;

/**
 * <a>Title: MultiplyString </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/23-10:54
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
 * <p>
 * link: https://leetcode-cn.com/problems/multiply-strings/
 */
public class MultiplyString {

    public static void main(String[] args) {
        String operatorOne = "123";
        String operatorTwo = "456";
        String multiplyString = getMultiplyString(operatorOne, operatorTwo);
        System.out.println("multiplyString = " + multiplyString);

        String theMultiplyStringNumber = getTheMultiplyStringNumber(operatorOne, operatorTwo);
        System.out.println("theMultiplyStringNumber = " + theMultiplyStringNumber);
    }

    /**
     * 字符串乘积
     *
     * @param operatorOne String
     * @param operatorTwo String
     * @return String
     */
    private static String getMultiplyString(String operatorOne, String operatorTwo) {
        if (operatorOne == null || operatorTwo == null) {
            throw new IllegalArgumentException("输入参数错误!");
        }
        boolean isZero = ("0".equals(operatorOne)) || ("0".equals(operatorTwo));
        if (isZero) {
            return "0";
        }
        String[] one = operatorOne.split("");
        String[] two = operatorTwo.split("");
        int calculator = 0;
        for (int i = one.length - 1; i >= 0; i--) {
            int elementOne = Integer.parseInt(one[i]);
            int carry = 0;
            int mul = 0;
            int digit = 0;
            int result = 0;
            int base = (int) Math.pow(10, one.length - 1 - i);
            for (int j = two.length - 1; j >= 0; j--) {
                int elementTwo = Integer.parseInt(two[j]);
                mul = elementOne * elementTwo;
                digit = mul % 10;
                result = (digit + carry) * base + result;
                carry = mul / 10;
                base *= 10;
                if (j == 0 && carry > 0) {
                    result = result + carry * base;
                }
            }
            calculator += result;
        }
        return String.valueOf(calculator);
    }

    /**
     * 字符串的乘积，将每次运算的结果保存在一个数组中，最后遍历数组进行拼串
     *
     * @param operatorOne String
     * @param operatorTwo String
     * @return String
     */
    private static String getTheMultiplyStringNumber(String operatorOne, String operatorTwo) {
        if (operatorOne == null || operatorTwo == null) {
            throw new IllegalArgumentException("输入参数错误!");
        }
        boolean isZero = ("0".equals(operatorOne)) || ("0".equals(operatorTwo));
        if (isZero) {
            return "0";
        }
        int[] array = new int[operatorOne.length() + operatorTwo.length()];
        for (int i = operatorOne.length() - 1; i >= 0; i--) {
            int elementOne = operatorOne.charAt(i) - '0';
            for (int j = operatorTwo.length() - 1; j >= 0; j--) {
                int elementTwo = operatorTwo.charAt(i) - '0';
                int sum = (array[i + j + 1] + elementOne * elementTwo);
                array[i + j] += sum / 10;
                array[i + j + 1] = sum % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && i == 0) {
                continue;
            }
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }
}
