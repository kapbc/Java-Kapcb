package com.kapcb.ccc.java.genericc;

import com.kapcb.ccc.util.Constants;

import java.util.logging.Logger;

/**
 * <a>Title: ArrayAlg </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/12 10:43
 */
public class ArrayAlg {

    private static final Logger logger = Logger.getLogger(String.valueOf(ArrayAlg.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    private ArrayAlg() {
    }

    /**
     * 获取最大和最小值
     *
     * @param array String[]
     * @return Pair<String>
     */
    public static <T extends Comparable> Pair<T> minAndMax(T[] array) {
        boolean legal = isLegal(array);
        T min = array[0];
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return new Pair<>(min, max);
    }

    /**
     * 获取数组中的最小值
     * 对类型变量进行限定，否则无法使用 compareTo 方法
     *
     * @param array T[]
     * @param <T>   <T extends Comparable>
     * @return T
     */
    public static <T extends Comparable> T min(T[] array) {
        boolean legal = isLegal(array);
        T smallest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (smallest.compareTo(array[i]) > 0) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    /**
     * judge
     *
     * @param array T[]
     * @param <T>   <T>
     * @return boolean
     */
    private static <T> boolean isLegal(T[] array) {
        if (array == null || array.length <= 0) {
            logger.warning("kapcb.system.practice.error");
            return false;
        } else {
            return true;
        }
    }
}
