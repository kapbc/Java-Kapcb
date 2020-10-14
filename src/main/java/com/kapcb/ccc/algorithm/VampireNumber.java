package com.kapcb.ccc.algorithm;

import java.util.ArrayList;
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

    public static void main(String[] args) throws Exception {
        Date startDate = new Date();
        long start = startDate.getTime();
        List<String> vampireNumber = getVampireNumber(4);
        Date endDate = new Date();
        long end = endDate.getTime();
        System.out.println("Time:" + (end - start));
        System.out.println("vampireNumber = " + vampireNumber);
    }

    private static List<String> getVampireNumber(int target) throws Exception {
        if (target <= 0) {
            throw new Exception("您输入的参数有误");
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
}
