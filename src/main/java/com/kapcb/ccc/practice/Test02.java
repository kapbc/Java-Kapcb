package com.kapcb.ccc.practice;

/**
 * <a>Title:Test02</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/18 17:49
 */
public class Test02 {

    private Test02() {
    }

    public static void caiShu(Integer target, Integer guess) {
        int i = guess - target;
        if (i == 0) {
            System.out.println("恭喜您猜对了!!!");
        } else if (i > 0 ? true : false) {
            System.out.println("您输入的数字大了!");
        } else {
            System.out.println("您输入的数字小了!");
        }
    }
}
