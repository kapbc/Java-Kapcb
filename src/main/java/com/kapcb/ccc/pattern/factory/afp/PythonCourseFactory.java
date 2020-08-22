package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:PythonCourseFactroy</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:26
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public INote creteNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
