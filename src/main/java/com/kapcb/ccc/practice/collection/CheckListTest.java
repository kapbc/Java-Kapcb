package com.kapcb.ccc.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * <a>Title: CheckListTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-11:06
 */
public class CheckListTest {
    private static final Logger logger = Logger.getLogger(String.valueOf(CheckListTest.class), "logmessage_en");

    public static void main(String[] args) {
        List<String> element = new ArrayList<>();
        List<String> es = Collections.checkedList(element, String.class);
        List a = es;
        try {
            a.add(new Date()); // ClassCastException
        } catch (ClassCastException e) {
            logger.warning("kapcb.checklist.type.exception");
        }
    }
}
