package com.kapcb.ccc.code.test.area;

/**
 * <a>Title:SphericalArea</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/24 2:17
 */
public class SphericalArea extends Area implements ISphericalArea {

    @Override
    public Double getSphericalSurfaceArea(Spherical spherical) {
        return super.CalculateSphericalSurfaceArea(spherical);
    }

    @Override
    public Double getVolume(Spherical spherical) {
        return super.CalculateSphericalVolume(spherical);
    }
}
