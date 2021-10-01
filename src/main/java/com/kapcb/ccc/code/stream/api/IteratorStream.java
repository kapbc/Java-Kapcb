package com.kapcb.ccc.code.stream.api;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * <a>Title: IteratorStream </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10-8:33
 */
public class IteratorStream {

    public static void main(String[] args) {
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
        iterate.forEach(System.out::println);
    }
}
