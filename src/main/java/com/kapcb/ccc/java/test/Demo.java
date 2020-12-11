package com.kapcb.ccc.java.test;

import java.util.Scanner;

/**
 * <a>Title:Demo</a>
 * <a>Author：ccc<a>
 * <a>Description：猜数字游戏：一个类a有一个实例变量，从键盘输入一个正整数为实例变量赋初始值。再定义一个类b，对类a的实例变量进行猜测.....<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/18 16:15
 */
public class Demo {
    public static void main(String[] args) {
        /**
         * 键盘扫描
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数!");
        /**
         * 从键盘上获取下一个输入的正整数
         */
        int target = scanner.nextInt();
        /**
         * 为类TargetNumber赋初始值
         */
        TargetNumber targetNumber = new TargetNumber(target);
        System.out.println("请猜测刚刚输入的数字!");
        Scanner scanner1 = new Scanner(System.in);
        /**
         * 获取键盘输入的猜测数字
         */
        int guessNumber = scanner1.nextInt();
        /**
         * 比较
         */
        int result = guessNumber - (targetNumber.getTarget());
        /**
         * 判断，还可换成switch 和 while
         */
        if (result > 0) {
            System.out.println("您输入的数字大了!");
        } else if (result < 0) {
            System.out.println("您输入的数字小了!");
        } else if (result == 0) {
            System.out.println("恭喜您，猜对了!!!");
        } else {
            System.out.println("您输入的参数有误");
        }
    }
}

class TargetNumber {
    private Integer target;

    /**
     * 有参构造器，为类赋初始值
     *
     * @param target Integer
     */
    public TargetNumber(Integer target) {
        this.target = target;
    }

    /**
     * getter setter方法
     * @return Integer
     */
    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
