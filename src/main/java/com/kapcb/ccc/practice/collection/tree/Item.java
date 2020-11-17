package com.kapcb.ccc.practice.collection.tree;

import java.util.Objects;

/**
 * <a>Title: Item </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/17-17:15
 */
public class Item implements Comparable<Item> {

    private int num;
    private String description;

    public Item() {
    }

    public Item(int num, String description) {
        this.num = num;
        this.description = description;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "[ description = " + description + ", num = " + num + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && num == other.num;
    }

    @Override
    public int compareTo(Item other) {
        int i = Integer.compare(num, other.num);
        return i != 0 ? i : description.compareTo(other.description);
    }
}
