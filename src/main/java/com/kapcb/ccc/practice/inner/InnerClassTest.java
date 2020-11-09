package com.kapcb.ccc.practice.inner;

import javax.swing.JOptionPane;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname InnerClassTest
 * @date 2020/11/9 10:44
 */
public class InnerClassTest {

    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000, true);
        talkingClock.start();

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
