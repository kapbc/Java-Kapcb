package com.kapcb.ccc.code.lambda.interval;

import java.awt.event.ActionEvent;
import java.time.Instant;

/**
 * <a>Title: Greeter </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-8:39
 */
public class Greeter {

    public void greet(ActionEvent event) {
        System.out.println("Hello, the time is " + Instant.ofEpochMilli(event.getWhen()));
    }
}
