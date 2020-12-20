package com.kapcb.ccc.java.test.area;

/**
 * <a>Title:SphericalArea</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/24 2:09
 */
public abstract class Area {
    /**
     * 计算表面积
     *
     * @param spherical CalculateSphericalSurfaceArea
     * @return Double
     */
    public Double CalculateSphericalSurfaceArea(Spherical spherical) {
        Double radius = spherical.getRadius();
        double surfaceArea = Math.PI * radius * radius;
        return surfaceArea;
    }

    /**
     * 计算体积
     *
     * @param spherical CalculateSphericalVolume
     * @return Double
     */
    public Double CalculateSphericalVolume(Spherical spherical) {
        Double radius = spherical.getRadius();
        Double height = spherical.getHeight();
        double volume = Math.PI * radius * radius * height;
        return volume;
    }
}
