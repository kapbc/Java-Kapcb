package com.kapcb.ccc.code.collection;

import com.kapcb.ccc.util.Constants;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <a>Title: PropertiesLoadTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/30-13:32
 */
public class PropertiesLoadTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(PropertiesLoadTest.class));

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(Constants.COMMON_PROGRAM_PROPERTIES_RESOURCES_PATH.getStringStatusCode());) {
            properties.load(fileInputStream);

            properties.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));
        } catch (Exception e) {
            logger.warning("System Exception" + e.getMessage());
        }

        String system = System.getProperty("user.home");
        System.out.println("system = " + system);
    }
}
