package com.kapcb.ccc.jvm.classload;

/**
 * <a>Title: HelloLinking </a>
 * <a>Author: Kapcb <a>
 * <a>Description: HelloLinking <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/17 22:14
 * @since 1.0
 */
public class HelloLinking {

    /**
     * Preparation 阶段只是为其赋初始值
     * Initialization 阶段将3赋值给a
     */
    private static int a = 3;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
