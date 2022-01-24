package com.kapcb.ccc.datastructure.data.stack;

import java.util.Scanner;

/**
 * <a>Title:ArrayToStackMain</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.1
 * @date 2020/10/31 8:08
 */
public class ArrayToStackMain {

    public static void main(String[] args) {





        ArrayToStack arrayToStack = null;
        boolean loop = true;
        boolean loopForStack = true;
        String next = "";
        String key = "";
        Scanner scanner = new Scanner(System.in);
        do {
            do {
                System.out.println("您需要自定义栈的初始容量吗？ y/n?");
                next = scanner.next();
                loop = (next == "") || (next == null) || ((!"y".equals(next)) && (!"n".equals(next)));
                if (loop) {
                    System.out.println("您输入的选项有误，请重新输入!");
                }
            } while (loop);
            if ("y".equals(next)) {
                do {
                    System.out.println("正在自定义初始化容量");
                    System.out.println("请输入一个正整数，定义您的初始化容量!");
                    int i = scanner.nextInt();
                    loop = i <= 0;
                    if (loop) {
                        System.out.println("自定义初始化容量不能设置容量为负数或者0,请重新输入!");
                    } else {
                        arrayToStack = new ArrayToStack(i);
                        System.out.println("初始化完成,容量为" + i);
                    }
                } while (loop);
            } else {
                System.out.println("使用默认初始化容量");
                arrayToStack = new ArrayToStack();
                System.out.println("初始化完成,容量为10");
            }

            if (arrayToStack == null) {
                System.out.println("初始化失败,请重新初始化");
            }
        } while (arrayToStack == null);

        while (loopForStack) {
            System.out.println("show:显示栈中的数据!");
            System.out.println("exit:退出程序!");
            System.out.println("push:添加数据(压栈)!");
            System.out.println("pop:取出数据(出栈)!");
            System.out.println("请输入选项进行响应功能!");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayToStack.getStackArray();
                    break;
                case "exit":
                    scanner.close();
                    loopForStack = false;
                    break;
                case "push":
                    System.out.println("请输入一个整数!");
                    int i = scanner.nextInt();
                    arrayToStack.push(i);
                    break;
                case "pop":
                    try {
                        int pop = arrayToStack.pop();
                        System.out.println("出栈的数据为: " + pop);
                    } catch (RuntimeException e) {
                        System.out.println("栈空!");
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
