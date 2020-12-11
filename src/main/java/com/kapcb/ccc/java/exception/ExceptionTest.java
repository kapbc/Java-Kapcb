package com.kapcb.ccc.java.exception;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ExceptionTest
 * @date 2020/11/10 9:53
 */
public class ExceptionTest {

    public static void main(String[] args) throws FileFormatException {
        testException("exception");
    }

    private static void testException(String test) throws FileFormatException {
        if (test != null && "exception".equals(test)) {
            throw new FileFormatException("文件格式错误");
        } else {
            System.out.println("文件格式正确");
        }
    }
}

