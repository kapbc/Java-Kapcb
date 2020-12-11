package com.kapcb.ccc.algorithm.thinkinjava;

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

    private static final int LOOP_START = 10;
    private static final int LOOP_END = 100;

    public static void main(String[] args) {
        Date startDate = new Date();
        List<String> vampireNumberMethodOne = getVampireNumberMethodOne(4);
        Date endDate = new Date();
        System.out.println("Method>>vampireNumberMethodOne Time:" + (endDate.getTime() - startDate.getTime()));
        System.out.println("vampireNumberMethodOne = " + vampireNumberMethodOne);

        Date startTime = new Date();
        List<String> vampireNumberMethodTwo = getVampireNumberMethodTwo(4);
        Date endTime = new Date();
        System.out.println("Method>>vampireNumberMethodTwo Time:" + (endTime.getTime() - startTime.getTime()));
        System.out.println("vampireNumberMethodTwo = " + vampireNumberMethodTwo);

        Date date = new Date();
        List<String> vampireNumberMethodThree = getVampireNumberMethodThree(4);
        Date date2 = new Date();
        System.out.println("Method>>vampireNumberMethodThree Time:" + (date2.getTime() - date.getTime()));
        System.out.println("vampireNumberMethodThree = " + vampireNumberMethodThree);
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
        for (int i = LOOP_START; i < LOOP_END; i++) {
            loop2:
            for (int j = LOOP_START; j < LOOP_END; j++) {
                boolean flag = true;
                int result = i * j;
                String targetNumber = result + "";
                if (targetNumber.length() < target) {
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
                        String vampireNumber = targetNumber + "=" + elementOne + "*" + elementTwo;
                        elementList.add(vampireNumber);
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

    /**
     * @param target int
     * @return List<String>
     */
    private static List<String> getVampireNumberMethodThree(int target) {
        if (target <= 0 || target % 2 != 0) {
            System.out.println("输入的参数有误");
            return null;
        }
        List<String> elementList = new ArrayList<>();
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                if ((i * j) % 9 != (i + j) % 9) {
                    continue;
                } else {
                    String resultNumber = String.valueOf(i * j);
                    String[] resultArray = resultNumber.split("");
                    Arrays.sort(resultArray);
                    String elementNumberOne = i + "";
                    String elementNumberTwo = j + "";
                    String operationNumber = elementNumberOne.concat(elementNumberTwo);
                    String[] operationArray = operationNumber.split("");
                    Arrays.sort(operationArray);
                    if (Arrays.equals(resultArray, operationArray)) {
                        String vampireNumber = resultNumber + "=" + elementNumberOne + "*" + elementNumberTwo;
                        elementList.add(vampireNumber);
                    }
                }
            }
        }
        return elementList;
    }
}
