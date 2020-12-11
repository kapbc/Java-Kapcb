package com.kapcb.ccc.java.genericc;

/**
 * <a>Title:PariTest </a>
 * <a>Author：kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/12 10:42
 */
public class PariTest {

    public static void main(String[] args) {
        String[] array = {"kapcb", "is", "a", "awesome", "man"};
        String[] arrayTest = null;
        Pair<String> stringPair = ArrayAlg.minAndMax(arrayTest);
        if (stringPair != null) {
            System.out.println("min = " + stringPair.getFirst() + ", max = " + stringPair.getSecond());
        } else {
            System.out.println(stringPair);
        }
    }
}
