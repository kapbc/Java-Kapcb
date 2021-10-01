package com.kapcb.ccc.code.inner;

import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname TalkingClock
 * @date 2020/11/9 10:13
 */
public class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock() {
    }

    public TalkingClock(int interval, boolean beep) {
        this.beep = beep;
        this.interval = interval;
    }

    public void start() {
        TimePrinter timePrinter = new TimePrinter();
        Timer timer = new Timer(interval, timePrinter);
        timer.start();
    }

    /**
     * 一个内部类方法可以访问自身的数据字段，也可以访问创建它的外围类对象的数据字段
     */
    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println("At the once, the time is" + Instant.ofEpochMilli(actionEvent.getWhen()));
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
