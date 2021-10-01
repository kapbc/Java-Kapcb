package com.kapcb.ccc.code.collection;

import java.util.BitSet;

/**
 * <a>Title: BitSetServer </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/30-14:18
 */
public class BitSetServer {

    public static void main(String[] args) {
        int n = 2000000;
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(n + 1);
        int count = 0;
        int i;
        for (i = 2; i <= n; i++) {
            bitSet.set(i);
        }
        i = 2;
        while (i * i <= n) {
            if (bitSet.get(i)) {
                count++;
                int k = 2 * i;
                while (k <= n) {
                    bitSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (bitSet.get(i)) {
                count++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "milliseconds");
    }
}
