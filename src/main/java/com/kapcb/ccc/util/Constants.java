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
     * Static Resources IO Path
     */
    COMMON_STREAM_TEST_TXT_RESOURCES_PATH("src/main/resource/streamTest.txt", "Stream Optional Test Static Resources Location"),
    COMMON_START_UP_PROPERTIES_RESOURCES_PATH("src/main/resource/start.properties", "Start Up Properties Resources Location"),
    COMMON_PROGRAM_PROPERTIES_RESOURCES_PATH("src/main/resource/program.properties", "Program Test Resources Location"),
    COMMON_LOG_MESSAGE_PROPERTIES_RESOURCES_PATH("src/main/resource/logmessage_en.properties", "The Log Message Properties Resources Path"),
    COMMON_CITY_TXT_RESOURCES_PATH("src/main/resource/cities.txt", "Stream City Test Resources Txt File"),
    COMMON_ALICE_TXT_RESOURCES_PATH("src/main/resource/alice30.txt", "Stream PrimitiveTypeStreams Test Txt File"),
    COMMON_MENU_TXT_RESOURCES_PATH("src/main/resource/menu.txt", "Stream Menu Resources Test Txt File"),

    /**
     * Try-Catch
     */
    COMMON_TRY_CATCH_EXCEPTION_INFO("Exception Information : ", "Try Catch Exception Information"),
    COMMON_TRY_CATCH_EXCEPTION_MESSAGE("The Exception Message is : ", "The Exception Message To Log"),

    /**
     * Logger
     */
    COMMON_LOGGER_RESOURCE_BUNDLE("logmessage_en", "Java Program Log ResourceBundle Path"),

    /**
     * Thread Name
     */
    COMMON_THREAD_NAME_A("Thread A", "Common Thread Name A"),
    COMMON_THREAD_NAME_B("Thread B", "Common Thread Name B"),

    /**
     * PrintStream
     */
    COMMON_SYSTEM_OUT_PRINTLN_STRING("Kapcb Nb!", "Common System Out Println String"),

    /**
     * Lock 8 Demonstration Common Print
     */
    COMMON_LOCK_8_PRINT_SEND_EMAIL("Send Email", "Print Send Email"),
    COMMON_LOCK_8_PRINT_SEND_SMS("Send SMS", "Print Send SMS"),
    COMMON_LOCK_8_PRINT_SAY_HELLO("Hello Kapcb!", "Print Say Hello"),

    /**
     * String Split Comma
     */
    COMMON_STRING_SPLIT_COMMA(", ", "Common String Split Comma"),
    COMMON_STRING_SPLIT_VERTICAL_LINE("|", "Common String Split Vertical Line"),
    COMMON_STRING_SPLIT_ESCAPE_VERTICAL_LINE("\\|", "Common String Split Escape Vertical Line"),

    /**
     * Time Formatter Pattern
     */
    COMMON_TIME_FORMATTER_PATTERN_DAY("yyyy-MM-dd", "Simple Time Formatter"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_12("yyyy-MM-dd hh:mm:ss", "LocalDateTime 12"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_24("yyyy-MM-dd HH:mm:ss", "LocalDateTime 24"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_12AP("yyyy-MM-dd hh:mm:ss a", "LocalDateTime 12 am and pm"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_24AP("yyyy-MM-dd HH:mm:ss a", "LocalDateTime 24 am and pm"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_12("yyyy-MM-dd hh:mm:ss:SSS", "LocalDateTime 12 Nano"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24("yyyy-MM-dd HH:mm:ss:SSS", "LocalDateTime 24 Nano"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_12AP("yyyy-MM-dd hh:mm:ss:SSS a", "LocalDateTime 12 Nano am and pm"),
    COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24AP("yyyy-MM-dd hh:mm:ss:SSS a", "LocalDateTime 24 Nano am and pm"),

    /**
     * Base-Number
     */
    COMMON_NUMBER_ONE(1, "Common base number constant One"),
    COMMON_NUMBER_TWO(2, "Common base number constant Two"),
    COMMON_NUMBER_THREE(3, "Common base number constant Three"),
    COMMON_NUMBER_FOUR(4, "Common base number constant Four"),
    COMMON_NUMBER_FIVE(5, "Common base number constant Five"),
    COMMON_NUMBER_SIX(6, "Common base number constant Six"),
    COMMON_NUMBER_SEVEN(7, "Common base number constant Seven"),
    COMMON_NUMBER_EIGHT(8, "Common base number constant Eight"),
    COMMON_NUMBER_NINE(9, "Common base number constant Nine"),
    COMMON_NUMBER_TEN(10, "Common base number constant Ten"),
    COMMON_NUMBER_STEP(1234, "Common base number constant Step");


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
