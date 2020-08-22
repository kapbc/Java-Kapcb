package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:AbstractFactoryPatternMain</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:28
 */
public class AbstractFactoryPatternMain {
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createVideo().record();
        factory.creteNote().write();
    }
}
