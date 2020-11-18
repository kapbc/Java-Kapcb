package com.kapcb.ccc.practice.conditional;


/**
 * <a>Title: IfTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/18-13:06
 *
 * link: https://medium.com/swlh/5-ways-to-replace-if-else-statements-857c0ff19357
 */
public class IfTest {

    public static void main(String[] args) {

    }

    /**
     * is statements with fast return
     *
     * @param input int
     * @return String
     */
    public static String DetermineGender(int input) {
        if (input == 0) {
            return "woman";
        }
        if (input == 1) {
            return "man";
        }
        return "unknown";
    }

    /**
     * value statement with if-else
     *
     * @param input int
     * @return String
     */
    public static String DetermineGenderNotRecommended(int input) {
        String gender = "";
        if (input == 0) {
            gender = "woman";
        } else if (input == 1) {
            gender = "man";
        } else {
            gender = "unknown";
        }
        return gender;
    }

    /**
     * check preconditions with guard clauses
     *
     * @param input int
     * @return String
     */
    public String DetermineGenderWithCheck(int input) {
        if (input < 0 || input > 1) {
            throw new IllegalArgumentException("参数错误!");
        }
        return input == 0 ? "woman" : "man";
    }

    /**
     * input value must be 0 or 1
     *
     * @param input
     * @return
     */
    public String DetermineGenderWithoutCheck(int input) {
        String gender = "";
        if (input == 0) {
            gender = "woman";
        } else if (input == 1) {
            gender = "man";
        } else {
            gender = "unknown";
        }
        return gender;
    }


    public void PerformOperationNotRecommended(String operationName) {
        if ("op1".equals(operationName)) {
            // something
        } else if ("op2".equals(operationName)) {
            // something else
        } else {
            // default
        }
    }
}
