package com.kapcb.ccc.jvm.lv;

/**
 * <a>Title: SlotTest </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SlotTest <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/27 16:40
 * @since 1.0
 */
public class SlotTest {

    public void localVar() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }

    public void localVar1() {
        {
            int a = 0;
            System.out.println(a);
        }

        // 此时就会复用 a 的槽位
        int b = 0;
    }


}
