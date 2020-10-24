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

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int ZERO = 0;

    public static void main(String[] args) {
        int i = 0;
        int choose = 0;
        double radius = 0;
        double height = 0;
        double radiusForVolume = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("=============请选择计算类型：=============");
                System.out.println("=============1.计算圆的面积==============");
                System.out.println("=============2.计算圆的体积==============");
                System.out.println("========================================");
                choose = scanner.nextInt();
                if (choose != ONE && choose != TWO) {
                    System.out.println("您的输入有误，请重新输入！");
                }
            } while (choose != ONE && choose != TWO);
            loop:
            switch (choose) {
                case 1:
                    Scanner scannerForSurfaceArea = new Scanner(System.in);
                    do {
                        System.out.println("请输入圆的半径:");
                        radius = scannerForSurfaceArea.nextDouble();
                        if (radius < ZERO) {
                            System.out.println("输入的参数有误，请重新输入!");
                        } else if (radius == ZERO) {
                            System.out.println("圆的表面积为:" + ZERO);
                            break loop;
                        }
                    } while (radius < ZERO);
                    Spherical sphericalForSurfaceArea = new Spherical(radius);
                    ISphericalArea sphericalArea = new SphericalArea();
                    Double sphericalSurfaceArea = sphericalArea.getSphericalSurfaceArea(sphericalForSurfaceArea);
                    System.out.println("圆的表面积为:" + sphericalSurfaceArea);
                    break;
                case 2:
                    Scanner scannerForVolume = new Scanner(System.in);
                    do {
                        System.out.println("请输入圆的高:");
                        height = scannerForVolume.nextDouble();
                        if (height < ZERO) {
                            System.out.println("输入的参数有误，请重新输入!");
                        } else if (height == ZERO) {
                            System.out.println("圆的体积为:" + ZERO);
                            break loop;
                        }
                    } while (height < ZERO);
                    do {
                        System.out.println("请输入圆面积的半径：");
                        radiusForVolume = scannerForVolume.nextDouble();
                        if (radiusForVolume < ZERO) {
                            System.out.println("输入的参数有误，请重新输入!");
                        } else if (radiusForVolume == ZERO) {
                            System.out.println("圆的体积为:" + ZERO);
                            break loop;
                        }
                    } while (radiusForVolume < ZERO);
                    Spherical sphericalForVolume = new Spherical(radiusForVolume, height);
                    ISphericalArea sphericalAreaForVolume = new SphericalArea();
                    Double volume = sphericalAreaForVolume.getVolume(sphericalForVolume);
                    System.out.println("圆的体积为:" + volume);
                    break;
                default:
                    System.out.println("您输入有误！请重新输入");
                    break;
            }
            System.out.println("=============您要退出吗?=============");
            System.out.println("=============1.退出=============");
            System.out.println("=============2.继续=============");
            System.out.println("========================================");
            Scanner scannerForLoop = new Scanner(System.in);
            i = scannerForLoop.nextInt();
        } while (i == TWO);
        System.out.println("欢迎下次继续来玩!!!!!");
    }
}
