package com.kapcb.ccc.java.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

/**
 * <a>Title: FixedDataIo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/4-16:00
 */
public class FixedDataIo {

    private FixedDataIo() {
    }

    public static String readFixedString(int size, DataInput dataInput) throws IOException {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean done = false;
        while (!done && i < size) {
            char c = dataInput.readChar();
            i++;
            if (Objects.equals(0, c)) {
                done = true;
            } else {
                sb.append(c);
            }
        }
        dataInput.skipBytes(2 * (size - 1));
        return sb.toString();
    }

    public static void writeFixedString(String source, int size, DataOutput dataOutput) throws IOException {
        for (int i = 0; i < size; i++) {
            char c = 0;
            if (source.length() > i) {
                c = source.charAt(i);
                dataOutput.write(c);
            }
        }
    }
}
