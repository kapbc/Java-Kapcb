package com.kapcb.ccc.java.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <a>Title: MaxInArray </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-13:32
 */
public class MaxInArray {

    private MaxInArray() {
    }

    public static <T extends Comparable> T getMaxInArray(Collection<T> collection) {
        if (collection.isEmpty()) {
            throw new NoSuchElementException("The Collection is empty! Please double check!");
        }
        Iterator<T> iterator = collection.iterator();
        T largest = iterator.next();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next.compareTo(largest) > 0) {
                largest = next;
            }
        }
        return largest;
    }
}
