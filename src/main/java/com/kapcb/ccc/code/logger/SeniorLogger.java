package com.kapcb.ccc.code.logger;

import java.util.logging.Logger;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname SeniorLogger
 * @date 2020/11/11 11:31
 */
public class SeniorLogger {

    private static final Logger logger = Logger.getLogger(String.valueOf(SeniorLogger.class));

    public static void main(String[] args) {
        logger.info("kapcb awesome man!!!");
    }
}
