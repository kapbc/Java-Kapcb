package com.kapcb.ccc.practice;

import java.util.Scanner;

/**
 * <a>Title:Demo1</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/18 16:42
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scannerTargetNumber = new Scanner(System.in);
        System.out.println("请输入一个正整数!");
        int targetNumber = scannerTargetNumber.nextInt();
        A a = new A(targetNumber);
        Scanner scannerGuessNumber = new Scanner(System.in);
        System.out.println("请输入一个数字猜测刚刚的数字!");
        int guessNumber = scannerGuessNumber.nextInt();
        if (guessNumber == a.getTarget()) {
            System.out.println("恭喜您，猜对了!!!");
        } else if (guessNumber - a.getTarget() > 0 ? true : false) {
            System.out.println("您输入的参数大了!");
        } else {
            System.out.println("您输入的参数小了!");
        }

    }
}
class A {
    private Integer target;

    public A(Integer target) {
        this.target = target;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
