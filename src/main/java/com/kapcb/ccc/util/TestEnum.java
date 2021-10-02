package com.kapcb.ccc.util;

/**
 * <a>Title: TestEnum </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/2 9:31
 */
public enum TestEnum {

    DEMO("test", "test");

    private String value;

    private String description;

    TestEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
