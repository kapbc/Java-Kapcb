package com.kapcb.ccc.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <a>Title: KapcbStartUp </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/3-9:02
 */
public class KapcbStartUp {

    private static final Logger logger = Logger.getLogger(String.valueOf(KapcbStartUp.class), "logmessage_en");

    public static void main(String[] args) {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resource/program.properties");) {
            properties.load(fileInputStream);
            for (int i = 0; i < 12; i++) {
                String key = "kapcb.test." + i;
                String property = properties.getProperty(key);
                System.out.println(property);
            }
        } catch (Exception e) {
            logger.warning("kapcb.test.fail");
            logger.warning("System Exception: " + e.getMessage());
        }
    }
}
