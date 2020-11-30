package com.kapcb.ccc.practice.collection;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <a>Title: PropertiesTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/30-13:16
 */
public class PropertiesTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(PropertiesTest.class), "logmessage_en");

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("width", "600px");
        properties.setProperty("kapcb", "nb");

        System.out.println(properties.getProperty("kapcb"));
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resource/program.properties");) {
            properties.store(fileOutputStream, "Program.properties");
        } catch (Exception e) {
            logger.warning("System error: " + e.getMessage());
        }
    }
}
