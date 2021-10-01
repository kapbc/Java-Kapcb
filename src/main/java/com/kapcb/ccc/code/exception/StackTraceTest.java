package com.kapcb.ccc.code.exception;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname ExceptionTest
 * @date 2020/11/10 9:53
 */
public class StackTraceTest {

    private static final String EXCEPTION_CONDITION = "exception";

    public static void main(String[] args) throws FileFormatException {
        testException("exception");
    }

    private static void testException(String test) throws FileFormatException {
        if (EXCEPTION_CONDITION.equals(test)) {
            throw new FileFormatException("文件格式错误");
        } else {
            System.out.println("文件格式正确");
        }
    }
}

