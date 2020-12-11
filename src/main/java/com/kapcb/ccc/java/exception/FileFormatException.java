package com.kapcb.ccc.java.exception;

import java.io.IOException;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname FileFormatException
 * @date 2020/11/10 9:50
 */
public class FileFormatException extends IOException {

    public FileFormatException() {
    }

    public FileFormatException(String message) {
        super(message);
    }

}
