package com.kapcb.ccc.test;


import java.util.Scanner;

/**
 * <a>Title:Test01</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/18 17:41
 */
public class Test01 {

    public static void main(String[] args) {
        int targetNumber, guessNumber;
        do {
            System.out.println("请输入一个目标数字!!");
            Scanner scannerTargetNumberScanner = new Scanner(System.in);
            targetNumber = scannerTargetNumberScanner.nextInt();
        } while (targetNumber < 0);
        do {
            System.out.println("请输入你猜的数字!!");
            Scanner scannerGuessNumberScanner = new Scanner(System.in);
            guessNumber = scannerGuessNumberScanner.nextInt();
        } while (guessNumber < 0);
        B b = new B(targetNumber);
        Test02.caiShu(b.getTarget(), guessNumber);
    }
}
class B {
    private Integer target;

    public B() {
    }

    public B(Integer target) {
        this.target = target;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }
}
