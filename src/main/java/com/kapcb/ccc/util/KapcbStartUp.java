package com.kapcb.ccc.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <a>Title: KapcbStartUp </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 * kapcb独家专属启动器!!!!
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/3-9:02
 */
public class KapcbStartUp {

    private static final int START_UP_STEP = 14;

    private static final String BASE_PROPERTIES_KEY = "kapcb.start.up.";

    private static final Logger logger = Logger.getLogger(String.valueOf(KapcbStartUp.class), "logmessage_en");

    private KapcbStartUp() {
    }

    public static void kapcbUp() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resource/start.properties");) {
            properties.load(fileInputStream);
            for (int i = 0; i < START_UP_STEP; i++) {
                String key = BASE_PROPERTIES_KEY + i;
                System.out.println(properties.getProperty(key));
            }
        } catch (Exception e) {
            logger.warning("kapcb.start.up.fail");
            logger.warning("System Exception: " + e.getMessage());
        }
    }
}
