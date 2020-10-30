package com.kapcb.ccc.practice.area;
/**
 * <a>Title:Spherical</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/24 1:58
 */
public class Spherical {
    private Double radius;
    private Double height;

    public Spherical() {
    }

    public Spherical(Double radius) {
        this.radius = radius;
    }

    public Spherical(Double radius, Double height) {
        this.radius = radius;
        this.height = height;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
