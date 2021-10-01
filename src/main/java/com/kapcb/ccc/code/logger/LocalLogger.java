package com.kapcb.ccc.code.logger;

import com.kapcb.ccc.util.Constants;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname LocalLogger
 * @date 2020/11/11 13:52
 */
public class LocalLogger {

    private static final Logger logger = Logger.getLogger(String.valueOf(LocalLogger.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {
        logger.info("kapcb.ccc");

        logger.log(Level.INFO, "kapcb.ccc.dynamic", new Object[]{"kapcb", "awesome"});

        logger.log(Level.INFO, "kapcb.ccc.dynamic", new Object[]{"That", "awesome"});
    }
}
