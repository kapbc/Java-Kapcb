package com.kapcb.ccc.util;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Formatter;
import java.util.stream.Stream;

/**
 * <a>Title: PrintUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 13:50
 */
public class PrintUtil {

    private static final PrintStream out = System.out;
    private static final Formatter forMatter = new Formatter(out);

    private PrintUtil() {
    }

    public static <T> void print(String description, T num) {
        String placeholder = Stream.of(num.getClass().getName()).map(s -> s.substring(s.lastIndexOf(".") + 1)).map(PrintUtil::getDataTypePlaceholder).findFirst().orElseThrow(IllegalArgumentException::new);
        forMatter.format(MessageFormat.format(description, placeholder), num);
    }

    private static String getDataTypePlaceholder(String name) {
        String operation = null;
        switch (name) {
            case "Double":
            case "Float":
                operation = "%f";
                break;
            case "Integer":
            case "Short":
            case "Byte":
            case "Long":
                operation = "%d";
                break;
            case "Boolean":
                operation = "%b";
                break;
            default:
                break;
        }
        return operation;
    }
}
