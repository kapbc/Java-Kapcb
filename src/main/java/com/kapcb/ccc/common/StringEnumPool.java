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

    /**
     * Static Resources IO Path
     */
    COMMON_MENU_TXT_RESOURCES_PATH("src/main/resource/txt/menu.txt", "Stream Menu Resources Test Txt File"),
    COMMON_CITY_TXT_RESOURCES_PATH("src/main/resource/txt/cities.txt", "Stream City Test Resources Txt File"),
    COMMON_EMAIL_HANDLER_RESOURCES_PATH("src/main/resource/txt/score.txt", "Email Handler Data Test Txt File"),
    COMMON_ALICE_TXT_RESOURCES_PATH("src/main/resource/txt/alice30.txt", "Stream PrimitiveTypeStreams Test Txt File"),
    COMMON_PROGRAM_PROPERTIES_RESOURCES_PATH("src/main/resource/program.properties", "Program Test Resources Location"),
    COMMON_START_UP_PROPERTIES_RESOURCES_PATH("src/main/resource/start.properties", "Start Up Properties Resources Location"),
    COMMON_STREAM_TEST_TXT_RESOURCES_PATH("src/main/resource/txt/streamTest.txt", "Stream Optional Test Static Resources Location"),
    COMMON_LOG_MESSAGE_PROPERTIES_RESOURCES_PATH("src/main/resource/logmessage_en.properties", "The Log Message Properties Resources Path"),

    /**
     * Try-Catch Error Message
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
    COMMON_LOCK_8_PRINT_SEND_SMS("Send SMS", "Print Send SMS"),
    COMMON_LOCK_8_PRINT_SEND_EMAIL("Send Email", "Print Send Email"),
    COMMON_LOCK_8_PRINT_SAY_HELLO("Hello Kapcb!", "Print Say Hello"),

    /**
     * String Split Comma
     */
    COMMON_STRING_SPLIT_COMMA(", ", "Common String Split Comma"),
    COMMON_STRING_SPLIT_VERTICAL_LINE("|", "Common String Split Vertical Line"),
    COMMON_STRING_SPLIT_ESCAPE_VERTICAL_LINE("\\|", "Common String Split Escape Vertical Line"),
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
