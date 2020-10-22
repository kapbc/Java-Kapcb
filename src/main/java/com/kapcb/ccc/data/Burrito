package com.kapcb.ccc.data;

/**
 * @author kapcb
 * @version 1.0.0
 * @classname Burrito
 * @description TODO
 * @date 2020/10/22 16:04
 */
public class Burrito {
    private Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public void describe() {
        System.out.println("The Burrito is:");
        switch (degree) {
            case NOT:
                System.out.println("not spicy at all!");
                break;
            case MILD:
                System.out.println("a little spicy!");
                break;
            case MEDIUM:
                System.out.println("too spicy!");
                break;
            case FLAMING:
                System.out.println("maybe too spicy!");
                break;
            default:
                System.out.println("are you kidding me?");
        }
    }

    public static void main(String[] args) {
        Burrito medium = new Burrito(Spiciness.MEDIUM);
        Burrito not = new Burrito(Spiciness.NOT);
        Burrito flaming = new Burrito(Spiciness.FLAMING);
        medium.describe();
        not.describe();
        flaming.describe();
    }
}
