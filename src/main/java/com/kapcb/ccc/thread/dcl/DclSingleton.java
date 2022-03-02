package com.kapcb.ccc.thread.dcl;

/**
 * <a>Title: DclSingleton </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DclSingleton <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/3/1 23:25
 * @since 1.0
 */
public class DclSingleton {

    private static volatile DclSingleton instance;

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

}
