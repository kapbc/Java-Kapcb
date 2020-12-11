package com.kapcb.ccc.practice.lambda.interval;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * <a>Title: RepeatedGreeter </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-8:39
 */
public class RepeatedGreeter extends Greeter {

    public void greet() {
        Timer timer = new Timer(2000, super::greet);
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit The Program!");
        System.exit(0);
    }
}
