package com.kapcb.ccc.java.test.area;

/**
 * <a>Title:ISphericalArea</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/24 2:19
 */
public interface ISphericalArea {

    /**
     * 获取表面积
     *
     * @param spherical Spherical
     * @return Double
     */
    Double getSphericalSurfaceArea(Spherical spherical);

    /**
     * 获取体积
     *
     * @param spherical Spherical
     * @return Double
     */
    Double getVolume(Spherical spherical);
}
