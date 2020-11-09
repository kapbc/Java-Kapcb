package com.kapcb.ccc.practice.inner;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
    }

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
