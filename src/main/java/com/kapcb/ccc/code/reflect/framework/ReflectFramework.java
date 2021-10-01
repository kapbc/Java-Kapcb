package com.kapcb.ccc.code.reflect.framework;

import com.kapcb.ccc.util.Constants;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * <a>Title: ReflectFramework </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/22 - 22:00
 */
public class ReflectFramework {

    private static final Logger logger = Logger.getLogger(String.valueOf(ReflectFramework.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {

        Properties properties = new Properties();
        ClassLoader classLoader = ReflectFramework.class.getClassLoader();
        /**
         * 使用类加载器, 获取配置文件中的配置内容
         */
        try (InputStream resourceAsStream = classLoader.getResourceAsStream("reflect_framework.properties")) {
            properties.load(resourceAsStream);
            String className = properties.getProperty("className");
            String methodName = properties.getProperty("methodName");

            /**
             * 加载该类进入内存
             */
            Class<?> personClassInRam = Class.forName(className);

            /**
             * 创建对象
             */
            Object o = personClassInRam.newInstance();

            /**
             * 获取方法对象
             */
            Method method = personClassInRam.getMethod(methodName);

            /**
             * 执行方法
             */
            method.invoke(o);

        } catch (Exception e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_INFO.getStringStatusCode() + e +
                    Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE.getStringStatusCode() + e.getMessage());
        }
    }
}
