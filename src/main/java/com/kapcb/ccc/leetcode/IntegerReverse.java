package com.kapcb.ccc.leetcode;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname IntegerReverse
 * @date 2020/11/10 15:20
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: -120
 * 输出: -21
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * link: https://leetcode-cn.com/problems/reverse-integer/
 */
public class IntegerReverse {

    public static void main(String[] args) {
        // [-2147483648, 2147483647]
        int a = -120;
        int integerReverse = getIntegerReverse(a);
        System.out.println("integerReverse = " + integerReverse);
    }

    /**
     * Integer类型最大值的个数为 7 ，最小值的个位数为 -8，target为整数，target*10也为整数
     *
     * @param target int
     * @return int
     */
    private static int getIntegerReverse(int target) {
        int temp = 0;
        int pop = 0;
        if (target == 0) {
            return target;
        }
        while (target != 0) {
            pop = target % 10;
            target /= 10;
            if (temp > Integer.MAX_VALUE || (temp == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (temp < Integer.MIN_VALUE || (temp == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            temp = temp * 10 + pop;
        }
        return temp;
    }

    /**
     * NotRecommended
     * 
     * int 类型转换为 String 是否存在精度丢失？？？
     *
     * @param target int
     * @return int
     */
    private static int getIntegerReverseNotRecommended(int target) {
        String operation = "";
        String element = String.valueOf(target);
        if (element.startsWith("-")) {
            operation = "-";
            element = element.replaceFirst("-", "");
        }
        String s = new StringBuilder(element).reverse().toString();
        if (s.startsWith("0")) {
            s = s.replaceFirst("0", "");
        }
        Integer integer = Integer.valueOf(operation + s);
        if ((Math.pow(-2, 31)) > integer || integer > (Math.pow(2, 31) - 1)) {
            return 0;
        } else {
            return integer;
        }
    }
}

