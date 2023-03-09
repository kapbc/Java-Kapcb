package com.kapcb.ccc.algorithm.primary.array.sort;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: SleepSort </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SleepSort <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/9 22:31
 * @since 1.0
 */
public class SleepSort {

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[]{4, 3, 2, 1, 8, 7, 6, 5, 0};

        int[] sort = sort(a);
        System.out.println(Arrays.toString(sort));
    }

    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static int[] sort(int[] array) throws InterruptedException {

        // 边界条件判断
        if (array == null) {
            return null;
        }

        int len = array.length;

        for (int i = 0; i < len; i++) {
            int j = i;
            Thread thread = new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(array[j] * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                queue.offer(array[j]);
            });
            thread.start();
        }

        int[] result = new int[len];
        for (int i = 0; i < result.length; ) {
            Integer num = queue.poll(1000L, TimeUnit.MILLISECONDS);
            if (num != null) {
                result[i] = num;
                i++;
            }
        }

        return result;
    }

}
