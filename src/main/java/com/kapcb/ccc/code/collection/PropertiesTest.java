package com.kapcb.ccc.code.collection;

import com.kapcb.ccc.util.Constants;

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

    private static final Logger logger = Logger.getLogger(String.valueOf(PropertiesTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("width", "600px");
        properties.setProperty("kapcb", "nb");

        System.out.println(properties.getProperty("kapcb"));
        try (FileOutputStream fileOutputStream = new FileOutputStream(Constants.COMMON_PROGRAM_PROPERTIES_RESOURCES_PATH.getStringStatusCode());) {
            properties.store(fileOutputStream, "Program.properties");
        } catch (Exception e) {
            logger.warning("System error: " + e.getMessage());
        }
    }
}
