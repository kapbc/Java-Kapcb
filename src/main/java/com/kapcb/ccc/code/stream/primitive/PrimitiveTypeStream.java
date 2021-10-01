package com.kapcb.ccc.code.stream.primitive;

import com.kapcb.ccc.util.Constants;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * <a>Title: PrimitiveTypeStream </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-16:07
 */
public class PrimitiveTypeStream {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8);
        IntStream stream = Arrays.stream(array, 0, 2);

        IntStream zeroToNinetyNine = IntStream.range(0, 100);   // Upper bound is excluded
        LongStream zeroToHundred = LongStream.rangeClosed(0, 100);   // Upper bound is included

        String sentence = "\uD835\uDD46 is the set of octonions.";
        IntStream codePoints = sentence.codePoints();

        String words = Constants.COMMON_LOCK_8_PRINT_SAY_HELLO.getStringStatusCode();
        IntStream stringLengthIntStream = Stream.of(words).mapToInt(String::length);

        Stream<Integer> boxed = IntStream.range(0, 100).boxed();
    }
}
