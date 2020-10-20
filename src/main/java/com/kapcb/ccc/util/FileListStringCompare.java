package com.kapcb.ccc.util;

import java.util.Comparator;

/**
 * <a>Title:FileListStringCompare</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/20 23:35
 */
public class FileListStringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
