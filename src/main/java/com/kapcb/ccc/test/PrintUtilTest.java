package com.kapcb.ccc.test;

import com.kapcb.ccc.util.PrintUtil;

/**
 * <a>Title: PrintUtilTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 14:05
 */
public class PrintUtilTest {

    public static void main(String[] args) {
        PrintUtil.print("The Double type number of Π is : {0}\n", 3.14D);

        PrintUtil.print("The Float type number of Π is : {0}\n", 3.14F);

        PrintUtil.print("The Integer type number of Π is : {0}\n", 3);

        PrintUtil.print("The String type number of Π is : {0}\n", "3.14");

        boolean flag = true;

        PrintUtil.print("The Boolean type number of Π is : {0}\n", flag);
    }
}
