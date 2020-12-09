package com.kapcb.ccc.practice.test;

import java.util.regex.Pattern;

/**
 * <a>Title:Test03</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/20 20:41
 */
public class Test03 {


    public static void main(String[] args) {
        String demo = "Develop-Tools\\IDEA\\IDEA-mvnRepository\\ant\\ant\\1.6.5";
        String demo01 = "D:\\Develop-Tools\\IDEA-KEY\\__MACOSX";
        String reg = "^D.*";
        boolean matches = Pattern.matches(reg, demo01);
        StringBuilder stringBuilder = new StringBuilder(demo01);
        String substring = stringBuilder.substring(0, 2);
        System.out.println("substring = " + substring);
        System.out.println("stringBuilder = " + stringBuilder);
        System.out.println(matches);
        if (demo01.indexOf("\\") > 0) {
            String s = demo.replaceAll("\\\\", "/");
            System.out.println(s);
        }
    }
}
