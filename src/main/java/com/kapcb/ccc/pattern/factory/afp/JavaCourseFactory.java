package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:JavaCourseFactroy</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:24
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public INote creteNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
