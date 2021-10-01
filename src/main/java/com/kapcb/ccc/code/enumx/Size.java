package com.kapcb.ccc.code.enumx;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Size
 * @date 2020/11/2 14:35
 */
public enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
    }
