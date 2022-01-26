package com.kapcb.ccc.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    private static final Logger logger = Logger.getLogger(String.valueOf(KapcbStartUp.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private KapcbStartUp() {
    }

    /**
     * 调用kapcb nb 启动logo
     */
    public static void kapcbUp() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(Constants.COMMON_START_UP_PROPERTIES_RESOURCES_PATH.getStringStatusCode());) {
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

    /**
     * Please check whether the StartUp have been insert into the properties
     * <p>
     * <p>
     * kapcb.start.up.0=---------------------------Start Up Begin------------------------------------
     * kapcb.start.up.1=|__    __                                __              __     __  __
     * kapcb.start.up.2=/  |  /  |                              /  |            /      /  |/  |
     * kapcb.start.up.3=$$ | /$$/   ______    ______    _______ $$ |____        $$     $$ |$$ |_____
     * kapcb.start.up.4=$$ |/$$/   /        /          /       |$$       |      $$$    $$ |$$       |
     * kapcb.start.up.5=$$  $$<   / $$$$$$ |/$$$$$$  |/$$$$$$$/ $$$$$$$  |      $$$$   $$ |$$$$$$$  |
     * kapcb.start.up.6=$$$$$    /      $$ |$$ |  $$ |$$ |   $$|$$ |  $$ |      $$ $$  $$ |$$|   $$ |
     * kapcb.start.up.7=$$ |$$  /  $$$$$$$ |$$ |__$$ |$$ |__   |$$ |__$$ |      $$ |$$ $$ |$$|__ $$ |
     * kapcb.start.up.8=$$ | $$ |  $$   $$ |$$    $$/ $$     $$|$$    $$/       $$ | $$$$ |$$    $$/
     * kapcb.start.up.9=$$/   $$/  $$$$$$$/ $$$$$$$/   $$$$$$$/ $$$$$$$/        $$/   $$/  $$$$$$$/
     * kapcb.start.up.10=|                   $$ |
     * kapcb.start.up.11=|                   $$ |
     * kapcb.start.up.12=|                   $$ /
     * kapcb.start.up.13=---------------------------Start Up Success----------------------------------
     */
//    public static void kapcbStartUpPropertiesInsert() {
    private static void kapcbStartUpPropertiesInsert() {
        Properties properties = new Properties();
        properties.setProperty("kapcb.start.up.0", "---------------------------Start Up Begin------------------------------------");
        properties.setProperty("kapcb.start.up.1", "|__    __                                __              __     __  __      ");
        properties.setProperty("kapcb.start.up.2", "/  |  /  |                              /  |            /      /  |/  |      ");
        properties.setProperty("kapcb.start.up.3", "$$ | /$$/   ______    ______    _______ $$ |____        $$     $$ |$$ |_____ ");
        properties.setProperty("kapcb.start.up.4", "$$ |/$$/   /        /          /       |$$       |      $$$    $$ |$$       |");
        properties.setProperty("kapcb.start.up.5", "$$  $$<     $$$$$$ |/$$$$$$  |/$$$$$$$/ $$$$$$$  |      $$$$   $$ |$$$$$$$  |");
        properties.setProperty("kapcb.start.up.6", "$$$$$      /    $$ |$$ |  $$ |$$ |   $$|$$ |  $$ |      $$ $$  $$ |$$|   $$ |");
        properties.setProperty("kapcb.start.up.7", "$$ |$$    /$$$$$$$ |$$ |__$$ |$$     __|$$ |__$$ |      $$ |$$ $$ |$$|___$$ |");
        properties.setProperty("kapcb.start.up.8", "$$ | $$  | $$   $$ |$$    $$/ $$       |$$    $$/       $$ | $$$$ |$$    $$/");
        properties.setProperty("kapcb.start.up.9", "$$/   $$/  $$$$$$$/ $$$$$$$/   $$$$$$$/ $$$$$$$/        $$/   $$/  $$$$$$$/");
        properties.setProperty("kapcb.start.up.10", "|                   $$ |                                                    ");
        properties.setProperty("kapcb.start.up.11", "|                   $$ |                                                    ");
        properties.setProperty("kapcb.start.up.12", "|                   $$ |                                                    ");
        properties.setProperty("kapcb.start.up.13", "---------------------------Start Up Success----------------------------------");
        try (FileOutputStream fileOutputStream = new FileOutputStream(Constants.COMMON_START_UP_PROPERTIES_RESOURCES_PATH.getStringStatusCode());) {
            properties.store(fileOutputStream, "#########################################kapcb start up########################################");
        } catch (Exception e) {
            logger.warning("kapcb.start.up.store.fail");
            logger.warning("System Exception: " + e.getMessage());
        }
    }

}
