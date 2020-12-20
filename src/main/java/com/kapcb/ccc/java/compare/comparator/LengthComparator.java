package com.kapcb.ccc.java.compare.comparator;

import java.util.Comparator;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname LengthComparator
 * @date 2020/11/3 9:25
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
