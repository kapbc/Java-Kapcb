package com.kapcb.ccc.practice.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname SimpleLogger
 * @date 2020/11/11 11:24
 */
public class SimpleLogger {


    public static void main(String[] args) {
        Logger.getGlobal().info("Kapcb awesome man!!!");

        Logger.getGlobal().setLevel(Level.OFF);

        Logger.getGlobal().warning("wow wow!!!");
    }
}
