package com.kapcb.ccc.code.enumx;

import com.kapcb.ccc.util.Constants;

import java.util.Arrays;

/**
 * <a>Title: ConstantsEnumTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10-14:27
 */
public class ConstantsEnumTest {

    public static void main(String[] args) {
        Constants message = Enum.valueOf(Constants.class, "COMMON_STREAM_TEST_TXT_RESOURCES_PATH");
        Constants[] values = Constants.values();
        System.out.println(message.getStringStatusCode());
        System.out.println(Arrays.asList(values));
    }
}
