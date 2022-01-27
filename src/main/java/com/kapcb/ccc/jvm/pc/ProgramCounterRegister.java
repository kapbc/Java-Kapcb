package com.kapcb.ccc.jvm.pc;

/**
 * <a>Title: ProgramCounterRegister </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ProgramCounterRegister <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/26 18:21
 * @since 1.0
 */
public class ProgramCounterRegister {

    public static void main(String[] args) {
        int minus = minus();
        System.out.println("minus = " + minus);
    }


    private static int minus() {
        int i = 3;
        int j = 4;
        return j - i;
    }

}
