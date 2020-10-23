package com.kapcb.ccc.data;



/**
 * @author kapcb
 * @version 1.0.0
 * @classname EnumOrder
 * @description TODO
 * @date 2020/10/22 16:02
 */
public class EnumOrder {
    public static void main(String[] args) {
        Spiciness[] values = Spiciness.values();
        for (Spiciness value : values) {
            System.out.println("index=" + value.ordinal() + ", value=" + value);
        }
    }
}
