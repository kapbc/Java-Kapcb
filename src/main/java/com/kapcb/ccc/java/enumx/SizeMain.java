package com.kapcb.ccc.java.enumx;

import java.util.Arrays;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname SizeMain
 * @date 2020/11/2 14:38
 */
public class SizeMain {
    public static void main(String[] args) {
        Size small = Enum.valueOf(Size.class, "SMALL");
        Size[] values = Size.values();
        System.out.println(small.getAbbreviation());
        System.out.println(Arrays.toString(values));
    }
}
