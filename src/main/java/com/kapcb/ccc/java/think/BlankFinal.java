package com.kapcb.ccc.java.think;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname BlankFinal
 * @date 2020/10/27 13:14
 */
public class BlankFinal {
    private final int i = 0;
    private final int j; //Blank final
    private final Poppet poppet; //Must be initialized in the constructor

    public BlankFinal() {
        this.j = 1; // initialized blank final reference
        this.poppet = new Poppet(1); // initialized blank final reference
    }

    public BlankFinal(int x) {
        j = x; // initialized blank final reference
        poppet = new Poppet(x); // initialized blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal(50);
        new BlankFinal(50);
    }
}
