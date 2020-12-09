package com.kapcb.ccc.util;

/**
 * <a>Title: Constants </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/9-13:56
 */
public enum Constants {

    /**
     * Stream Optional Test Static Resources Location
     */
    COMMON_RESOURCES_PATH("src/main/resource/streamTest.txt", "Stream Optional Test Static Resources Location"),
    COMMON_LOGGER_PATH("logmessage_en", "Java Program Log ResourceBundle Path");

    private String stringStatusCode;
    private int numberStatusCode;
    private String description;

    private Constants() {
    }

    /**
     * Number Constant Constructor
     *
     * @param numberStatusCode int
     * @param description      String
     */
    private Constants(int numberStatusCode, String description) {
        this.setNumberStatusCode(numberStatusCode);
        this.description = description;
    }

    /**
     * String Constant Constructor
     *
     * @param stringStatusCode String
     * @param description      String
     */
    private Constants(String stringStatusCode, String description) {
        this.setStringStatusCode(stringStatusCode);
        this.description = description;
    }

    /**
     * Only able to get the constant value
     *
     * @return String
     */
    public String getStringStatusCode() {
        return stringStatusCode;
    }

    /**
     * Only able to get the constant value
     *
     * @return int
     */
    public int getNumberStatusCode() {
        return numberStatusCode;
    }

    private void setStringStatusCode(String stringStatusCode) {
        this.stringStatusCode = stringStatusCode;
    }

    private void setNumberStatusCode(int numberStatusCode) {
        this.numberStatusCode = numberStatusCode;
    }
}
