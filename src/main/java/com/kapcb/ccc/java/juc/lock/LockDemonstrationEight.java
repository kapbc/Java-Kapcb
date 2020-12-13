package com.kapcb.ccc.java.juc.lock;

import com.kapcb.ccc.util.Constants;

/**
 * <a>Title: LockDemonstrationEight </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/13 - 12:15
 */
public class LockDemonstrationEight {

    public static void main(String[] args) {
        new Phone()

    }

    private static class Phone {
        public static synchronized void sendEmail() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_EMAIL.getStringStatusCode());
        }

        public synchronized void sendSMS() {
            System.out.println(Constants.COMMON_LOCK_8_PRINT_SEND_SMS.getStringStatusCode());
        }
    }
}
