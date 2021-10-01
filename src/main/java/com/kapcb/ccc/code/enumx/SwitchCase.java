package com.kapcb.ccc.code.enumx;

/**
 * <a>Title: SwitchCase </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/17-16:31
 */
public class SwitchCase {

    public static void main(String[] args) {
        long convertId170 = convertIdToPrefix(4000001234567L, "400");
        long convertId400 = convertIdToPrefix(1700001234567L, "170");
        long convertId200 = convertIdToPrefix(6000001234567L, "600");
        System.out.println("convertId170 = " + convertId170);
        System.out.println("convertId400 = " + convertId400);
        System.out.println("convertId200 = " + convertId200);
    }

    private static long convertIdToPrefix(long id, String prefix) {
        if (id < 0) {
            return 0L;
        }
        long operationNumber = 0L;
        switch (prefix) {
            case "400":
                operationNumber = -2300000000000L;
                break;
            case "170":
                operationNumber = 2300000000000L;
                break;
            case "600":
                operationNumber = -4000000000000L;
                break;
            default:
                break;
        }
        long convertId = id;
        if (String.valueOf(convertId).startsWith(prefix) && operationNumber != 0) {
            convertId = convertId + operationNumber;
        }
        return convertId;
    }
}
