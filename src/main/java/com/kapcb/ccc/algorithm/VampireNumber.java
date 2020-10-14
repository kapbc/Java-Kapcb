package com.kapcb.ccc.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * <a>Title:VampireNumber</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/14 22:01
 */
public class VampireNumber {

//    Logger logger = Logger.getLogger(VampireNumber.class.getName());

    public static void main(String[] args) throws Exception {
        List<String> vampireNumber = getVampireNumber(4);
        System.out.println("vampireNumber = " + vampireNumber);
    }

    private static List<String> getVampireNumber(int target) throws Exception {
        if (target <= 0) {
            throw new Exception("输入参数有误");
        }
        List<String> elementList = new ArrayList<>();
        loop1:
        for (int i = 10; i < 100; i++) {
            loop2:
            for (int j = 10; j < 100; j++) {
                boolean flag = true;
                int result = i * j;
                String targetNumber = result + "";
                System.out.println("targetNumber = " + targetNumber);
                if (targetNumber.length() < 4) {
                    flag = false;
                    System.out.println("j = " + j);
                    continue loop2;
                }
                if (flag) {
                    String elementOne = i + "";
                    System.out.println("elementOne = " + elementOne);
                    String elementTwo = j + "";
                    System.out.println("elementTwo = " + elementTwo);
                    String element = elementOne.concat(elementTwo);
                    System.out.println("element = " + element);
                    String[] split = element.split("");
                    String tempString = targetNumber;
                    System.out.println("split.length = " + split.length);
                    for (int k = 0; k < split.length; k++) {
                        System.out.println("k = " + k);
                        if (!tempString.contains(split[k])) {
                            continue ;
                        } else {
//                            int startIndex = tempString.indexOf(split[k]);
//                            System.out.println("startIndex = " + startIndex);
//                            tempString = targetNumber.substring(startIndex, startIndex + 1);
                            tempString = targetNumber.replaceFirst(split[k], "");
                            System.out.println("split[k] = " + split[k]);
                            System.out.println("tempString = " + tempString);
                        }
                    }
                    String s = targetNumber + "=" + elementOne + "*" + elementTwo;
                    elementList.add(s);
                }
            }
        }
        return elementList;
    }
}
