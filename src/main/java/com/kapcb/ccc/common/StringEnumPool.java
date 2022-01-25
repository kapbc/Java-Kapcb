package com.kapcb.ccc.common;

/**
 * <a>Title: StringEnumPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: StringEnumPool <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/25 14:02
 * @since 1.0
 */
public enum StringEnumPool implements IEnum<String> {





    ;

    private String value;

    private String description;

    StringEnumPool(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String value() {
        return this.value;
    }

}
