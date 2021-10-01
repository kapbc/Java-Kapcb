package com.kapcb.ccc.code.printformatter;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * <a>Title: Turtle </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 13:05
 */
public class Turtle {

    private String name;
    private Formatter formatter;

    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s The Turtle is at (%d, %d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        Turtle kapcb = new Turtle("kapcb", new Formatter(out));
        Turtle ccccc = new Turtle("ccccc", new Formatter(out));
        kapcb.move(0, 0);
        ccccc.move(4, 8);
        kapcb.move(3, 4);
        ccccc.move(2, 5);
        kapcb.move(3, 3);
        ccccc.move(3, 3);
    }
}
