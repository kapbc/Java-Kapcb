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
    MENU_TXT_RESOURCES_PATH("src/main/resource/txt/menu.txt", "Stream Menu Resources Test Txt File"),
    CITY_TXT_RESOURCES_PATH("src/main/resource/txt/cities.txt", "Stream City Test Resources Txt File"),
    EMAIL_HANDLER_RESOURCES_PATH("src/main/resource/txt/score.txt", "Email Handler Data Test Txt File"),
    ALICE_TXT_RESOURCES_PATH("src/main/resource/txt/alice30.txt", "Stream PrimitiveTypeStreams Test Txt File"),
    PROGRAM_PROPERTIES_RESOURCES_PATH("src/main/resource/program.properties", "Program Test Resources Location"),
    START_UP_PROPERTIES_RESOURCES_PATH("src/main/resource/start.properties", "Start Up Properties Resources Location"),
    STREAM_TEST_TXT_RESOURCES_PATH("src/main/resource/txt/streamTest.txt", "Stream Optional Test Static Resources Location"),
    LOG_MESSAGE_PROPERTIES_RESOURCES_PATH("src/main/resource/logmessage_en.properties", "The Log Message Properties Resources Path"),

    /**
     * Try-Catch Error Message
     */
    EXCEPTION_INFO("Exception Information : ", "Try Catch Exception Information"),
    EXCEPTION_MESSAGE("The Exception Message is : ", "The Exception Message To Log"),
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
