package com.kapcb.ccc.pattern.factory.afp;

/**
 * <a>Title:CourseFactory</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/8/22 16:21
 */
public interface CourseFactory {
    /**
     * 创建笔记
     *
     * @return INote
     */
    INote creteNote();

    /**
     * 创建视频
     *
     * @return IVideo
     */
    IVideo createVideo();
}
