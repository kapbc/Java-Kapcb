package com.kapcb.ccc.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a>Title:PatternDemo</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/7 0:35
 */
public class PatternDemo {
    public static void main(String[] args) {
        System.out.println("testOne");
        patternRegexOne();
        System.out.println("testTwo");
        patternRegexTwo();
        System.out.println("testThree");
        patternRegexThree();
        System.out.println("testFour");
        patternRegexFour();
    }

    public static void patternRegexOne() {
        String text = "This is the text to be searched" + "for occurrences of the http://pattern";
        String pattern = ".*http://.*";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);
    }

    public static void patternRegexTwo() {
        String text = "This is the text to be searched" + "for kapcb" + "aaa";
        String pattern = ".*kapcb";
        boolean matches = Pattern.matches(pattern, text);
        System.out.println("matches = " + matches);
    }

    public static void patternRegexThree() {
        String text = "This is the text to be searched" + "for kapcb" + "aaa";
        String patternTemplate = ".*kapcb.*";
        Pattern compile = Pattern.compile(patternTemplate, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(text);
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
    }

    public static void patternRegexFour() {
        String text = "A kapcb Text kapcb With kapcb Many kapcb bkapcbSeparators";
        String patternTemplate = "kapcb";
        Pattern compile = Pattern.compile(patternTemplate, Pattern.CASE_INSENSITIVE);
        String[] split = compile.split(text);
        System.out.println("split.length = " + split.length);
        Arrays.stream(split).forEach(System.out::println);
    }

}
