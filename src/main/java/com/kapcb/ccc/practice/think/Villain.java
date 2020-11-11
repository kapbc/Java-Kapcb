package com.kapcb.ccc.practice.think;

public class Villain {
    private String name;

    protected void set(String name) {
        this.name = name;
    }

    public Villain(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "I am a com.kapcb.ccc.practice.Villain and my name is " + name;
    }
}
