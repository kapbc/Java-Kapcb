package com.kapcb.ccc.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <a>Title:VampireNumber</a>
 * <a>Author：ccc<a>
 * <a>Description：吸血鬼数<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/14 22:01
 */
public class VampireNumber {

    public static void main(String[] args) {
        Date startDate = new Date();
        long start = startDate.getTime();
        List<String> vampireNumberMethodOne = getVampireNumberMethodOne(4);
        Date endDate = new Date();
        long end = endDate.getTime();
        System.out.println("Method>>vampireNumberMethodOne Time:" + (end - start));
        System.out.println("vampireNumberMethodOne = " + vampireNumberMethodOne);

        Date startTime = new Date();
        long timeStart = startTime.getTime();
        List<String> vampireNumberMethodTwo = getVampireNumberMethodTwo(4);
        Date endTime = new Date();
        long timeEnd = endTime.getTime();
        System.out.println("Method>>vampireNumberMethodTwo Time:" + (timeEnd - timeStart));
        System.out.println("vampireNumberMethodTwo = " + vampireNumberMethodTwo);
    }

    /**
     * @param target int
     * @return List<String>
     */
    private static List<String> getVampireNumberMethodOne(int target) {
        if (target <= 0 || target % 2 != 0) {
            System.out.println("您输入的参数有误");
            return null;
        }
        List<String> elementList = new ArrayList<>();
        loop1:
        for (int i = 10; i < 100; i++) {
            loop2:
            for (int j = 10; j < 100; j++) {
                boolean flag = true;
                int result = i * j;
                String targetNumber = result + "";
                if (targetNumber.length() < 4) {
                    flag = false;
                    continue loop2;
                }
                if (flag) {
                    String elementOne = i + "";
                    String elementTwo = j + "";
                    String element = elementOne.concat(elementTwo);
                    String[] split = element.split("");
                    String tempString = targetNumber;
                    for (int k = 0; k < split.length; k++) {
                        if (!tempString.contains(split[k])) {
                            continue loop2;
                        } else {
                            tempString = tempString.replaceFirst(split[k], "");
                        }
                    }
                    if (tempString.isEmpty()) {
                        String s = targetNumber + "=" + elementOne + "*" + elementTwo;
                        elementList.add(s);
                    }
                }
            }
        }
        return elementList;
    }

    /**
     * @param target int
     * @return List<String>
     */
    private static List<String> getVampireNumberMethodTwo(int target) {
        if (target <= 0 || target % 2 != 0) {
            System.out.println("输入的参数有误!");
            return null;
        }
        List<String> elementList = new ArrayList<>();
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                int result = i * j;
                if (String.valueOf(result).length() < target) {
                    continue;
                } else {
                    String elementOne = i + "";
                    String elementTwo = j + "";
                    String element = elementOne.concat(elementTwo);
                    String[] operationNumber = element.split("");
                    String elementResult = String.valueOf(result);
                    String[] resultNumber = elementResult.split("");
                    Arrays.sort(operationNumber);
                    Arrays.sort(resultNumber);
                    if (Arrays.equals(resultNumber, operationNumber)) {
                        String vampireNumber = elementResult + "=" + elementOne + "*" + elementTwo;
                        elementList.add(vampireNumber);
                    }
                }
            }
        }
        return elementList;
    }
}
