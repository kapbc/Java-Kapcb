package com.kapcb.ccc.practice.genericClass;

import java.util.logging.Logger;

/**
 * <a>Title:ArrayAlg </a>
 * <a>Author：kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/12 10:43
 */
public class ArrayAlg {

    private static final Logger logger = Logger.getLogger(String.valueOf(ArrayAlg.class), "logmessage_en");

    private ArrayAlg() {
    }

    public static Pair<String> minAndMax(String[] array) {
        if (array == null || array.length <= 0) {
            logger.warning("kapcb.system.practice.error");
            return null;
        }
        String min = array[0];
        String max = array[0];
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
}
