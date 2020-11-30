package com.kapcb.ccc.practice.collection;

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
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resource/program.properties");) {
            properties.load(fileInputStream);

            properties.forEach((k, v) -> System.out.println("k=" + k + ", v=" + v));
        } catch (Exception e) {
            logger.warning("System Exception" + e.getMessage());
        }
    }
}
