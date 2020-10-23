package com.kapcb.ccc.test;

import java.util.Scanner;

/**
 * <a>Title:SphericalAreaMain</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/10/24 2:23
 */
public class SphericalAreaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============请选择计算类型：=============");
        System.out.println("=============1.计算圆的面积==============");
        System.out.println("=============2.计算圆的体积==============");
        System.out.println("========================================");
        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                System.out.println("请输入圆面积的半径：");
                Scanner scanner1 = new Scanner(System.in);
                double banjin = scanner1.nextDouble();
                Spherical spherical = new Spherical(banjin);
                SphericalArea sphericalArea = new SphericalArea();
                sphericalArea.getSphericalSurfaceArea(spherical);
            break;
            case 2:

        }
        ISphericalArea sphericalArea = new SphericalArea();
        Spherical spherical = new Spherical(10.00, 10.00);
        Double sphericalSurfaceArea = sphericalArea.getSphericalSurfaceArea(spherical);
        System.out.println("圆的表面积为:" + sphericalSurfaceArea);
        Double volume = sphericalArea.getVolume(spherical);
        System.out.println("圆的体积为:" + volume);
    }
}
