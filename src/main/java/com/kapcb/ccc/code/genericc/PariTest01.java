package com.kapcb.ccc.code.genericc;

import java.time.LocalDate;

/**
 * <a>Title: PariTest01 </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/12-15:33
 */
public class PariTest01 {

    public static void main(String[] args) {
        LocalDate[] birthday = {
                LocalDate.of(1997, 03, 11),
                LocalDate.of(1998, 04, 12),
                LocalDate.of(1998, 05, 1),
                LocalDate.of(1999, 06, 2),
        };
        Pair<LocalDate> localDatePair = ArrayAlg.minAndMax(birthday);
        System.out.println("min = " + localDatePair.getFirst() + ", max = " + localDatePair.getSecond());
    }
}
