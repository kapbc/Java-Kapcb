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
     * IO Path
     */
    COMMON_STREAM_TEST_TXT_RESOURCES_PATH("src/main/resource/streamTest.txt", "Stream Optional Test Static Resources Location"),
    COMMON_START_UP_PROPERTIES_RESOURCES_PATH("src/main/resource/start.properties", "Start Up Properties Resources Location"),
    COMMON_PROGRAM_TEST_PROPERTIES_RESOURCES_PATH("src/main/resource/program.properties", "Program Test Resources Location"),


    /**
     * Try-Catch
     */
    COMMON_TRY_CATCH_EXCEPTION_INFO("Exception Information : ", "Try Catch Exception Information"),
    COMMON_TRY_CATCH_EXCEPTION_MESSAGE("The Exception Message is : ", "The Exception Message To Log"),


    /**
     * Logger
     */
    COMMON_LOGGER_PATH("logmessage_en", "Java Program Log ResourceBundle Path"),


    /**
     * Thread Name
     */
    COMMON_THREAD_NAME_A("Thread A", "common thread name"),
    COMMON_THREAD_NAME_B("Thread B", "common thread name"),

    /**
     * Common system out println String
     */
    COMMON_SYSTEM_OUT_PRINTLN_STRING("Kapcb Nb!", "Common log"),

    /**
     * Base Number Constant
     */
    COMMON_NUMBER_ONE(1, "One"),
    COMMON_NUMBER_TWO(2, "two"),
    COMMON_NUMBER_THREE(3, "three"),
    COMMON_NUMBER_FOUR(4, "four"),
    COMMON_NUMBER_FIVE(5, "five"),
    COMMON_NUMBER_SIX(6, "six"),
    COMMON_NUMBER_SEVEN(7, "seven"),
    COMMON_NUMBER_EIGHT(8, "eight"),
    COMMON_NUMBER_NINE(9, "nine"),
    COMMON_NUMBER_TEN(10, "ten");


    /**
     * String Code
     */
    private String stringStatusCode;

    /**
     * int Code
     */
    private int numberStatusCode;

    /**
     * Description
     */
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
