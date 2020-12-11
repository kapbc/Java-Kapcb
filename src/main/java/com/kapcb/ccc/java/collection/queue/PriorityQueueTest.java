package com.kapcb.ccc.java.collection.queue;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a>Title: PriorityQueue </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-14:35
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<LocalDate> queue = new PriorityQueue<>();
        queue.add(LocalDate.of(2001, 07, 15));
        queue.add(LocalDate.of(1998, 04, 12));
        queue.add(LocalDate.of(2000, 06, 14));
        queue.add(LocalDate.of(1997, 03, 11));
        queue.add(LocalDate.of(1999, 05, 13));

        System.out.println("Iterator over elements...");
        Iterator<LocalDate> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Removing the elements...");
        while (!queue.isEmpty()) {
            LocalDate remove = queue.remove();
            System.out.println(remove);
        }
    }
}
