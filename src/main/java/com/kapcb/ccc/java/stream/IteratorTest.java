package com.kapcb.ccc.java.stream;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * <a>Title: IteratorTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10-8:33
 */
public class IteratorTest {

    public static void main(String[] args) {
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
        iterate.forEach(System.out::println);
    }
}
