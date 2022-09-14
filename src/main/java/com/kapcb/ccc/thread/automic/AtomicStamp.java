package com.kapcb.ccc.thread.automic;

import com.kapcb.ccc.util.SleepHelper;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <a>Title: AtomicStamp </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AtomicStamp <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/3/6 23:16
 * @since 1.0
 */
public class AtomicStamp {

    private static AtomicInteger atomicInteger = new AtomicInteger(10);

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(getCurrentThreadName() + " 第1次版本号 : " + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(10, 11, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(getCurrentThreadName() + " 第2次版本号 : " + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(11, 10, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(getCurrentThreadName() + " 第3次版本号 : " + atomicStampedReference.getStamp());

        }, "A").start();

        new Thread(() -> {
            System.out.println(getCurrentThreadName() + " 第1次版本号 : " + atomicStampedReference.getStamp());

            SleepHelper.sleep(2);

            boolean casSuccess = atomicStampedReference.compareAndSet(10, 12, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);

            System.out.println(getCurrentThreadName() + " 是否修改成功 : " + casSuccess + " 当前版本为 : " + atomicStampedReference.getStamp());
            System.out.println(getCurrentThreadName() + " 当前实际值 : " + atomicStampedReference.getReference());

        }, "B").start();
    }

    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

}
