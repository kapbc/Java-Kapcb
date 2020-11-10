package com.kapcb.ccc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ZConversion
 * @date 2020/11/10 14:51
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比
 * 如："LCIRETOESIIGEDHN"。
 * <p>
 * link: https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class ZConversion {

    public static void main(String[] args) {
        String target = "LEETCODEISHIRING";
        int rows = 4;
        String convert = convert(target, rows);
        System.out.println("convert = " + convert);
    }

    private static String convert(String target, int rows) {
        if (rows <= 0) {
            System.out.println("参数输入有误!!!");
            return null;
        } else if (rows == 1) {
            return target;
        }
        List<StringBuffer> elementList = new ArrayList<>();
        for (int i = 0; i < Math.min(rows, target.length()); i++) {
            elementList.add(new StringBuffer());
        }

        int index = 0;
        boolean flag = false;
        for (char c : target.toCharArray()) {
            elementList.get(index).append(c);
            if (index == 0 || index == rows - 1) {
                flag = !flag;
            }
            index += flag ? 1 : -1;
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer stringBuffer : elementList) {
            result.append(stringBuffer);
        }
        return result.toString();
    }
}
