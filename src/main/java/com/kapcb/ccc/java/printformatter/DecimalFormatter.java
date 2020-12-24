package com.kapcb.ccc.java.printformatter;

import java.text.DecimalFormat;

/**
 * <a>Title: DecimalFormatter</a>
 * <a>Author: <a>
 * <a>Description: <a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/12/25 0:09
 */
public class DecimalFormatter {

    public static void main(String[] args) {
        Integer point = 15159;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String format = decimalFormat.format(point);
        System.out.println("format = " + format);
    }
}
