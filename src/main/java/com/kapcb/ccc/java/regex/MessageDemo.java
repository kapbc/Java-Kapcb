package com.kapcb.ccc.java.regex;

import java.text.MessageFormat;

/**
 * <a>Title:MessageFromat</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/7 0:35
 */
public class MessageDemo {
    private static final String DEMO_ONE = "kapcb";
    private static final String DEMO_TWO = "eircc";
    private static final String DEMO_THREE = "demo";
    private static final String DEMO_FOUR = "hi";
    private static final String DEMO_FIVE = "awesome";
    private static final String DEMO_SIX = "man";

    public static void main(String[] args) {
        String message = "{0}/{1}/{2}/{3}-{4}-{5}";
        Object[] objects = {DEMO_ONE, DEMO_TWO, DEMO_THREE, DEMO_FOUR, DEMO_FIVE, DEMO_SIX};
        String format = MessageFormat.format(message, objects);
        System.out.println(format);
    }
}
