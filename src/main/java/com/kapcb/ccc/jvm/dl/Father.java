package com.kapcb.ccc.jvm.dl;

/**
 * <a>Title: Father </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Father <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/27 20:19
 * @since 1.0
 */
public class Father {

    public static void eat(String food) {
        System.out.println("transfer father's eat method call : " + food);
    }

    public static void say(String keyword) {
        System.out.println("transfer father's say method call : " + keyword);
    }

    public static class Son extends Father {

    }




    public static class VirtualMethodTest {

        public static void main(String[] args) {

            Son.eat("noodles");

            Son.say("Hello, I'm Kapcb!");
        }

    }

}
