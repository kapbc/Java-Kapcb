package com.kapcb.ccc.common;

/**
 * <a>Title: IntegerEnumPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IntegerEnumPool <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/1/26 17:46
 * @since 1.0
 */
public enum IntegerEnumPool implements IEnum<Integer> {

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


    private Integer value;

    private String description;

    IntegerEnumPool(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer value() {
        return this.value;
    }

}
