package com.kapcb.ccc.practice.think;

import com.kapcb.ccc.practice.Villain;

public class Orc extends Villain {
    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        set(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc limburger = new Orc("Limburger", 12);
        System.out.println(limburger);
        limburger.change("Bob", 19);
        System.out.println(limburger);
    }
}
