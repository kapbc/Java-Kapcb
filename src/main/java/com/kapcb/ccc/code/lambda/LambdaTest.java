package com.kapcb.ccc.code.lambda;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.time.Instant;

/**
 * <a>Title: LambdaTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/1-10:22
 */
public class LambdaTest {

    public static void main(String[] args) {
        RepeatedGreeter repeatedGreeter = new RepeatedGreeter();
        repeatedGreeter.greet();
    }
}

class Greeter {

    public void greet(ActionEvent event) {
        System.out.println("Hello, the time is " + Instant.ofEpochMilli(event.getWhen()));
    }

}

class RepeatedGreeter extends Greeter {

    public void greet() {
        Timer timer = new Timer(2000, super::greet);
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit The Program!");
        System.exit(0);
    }
}
