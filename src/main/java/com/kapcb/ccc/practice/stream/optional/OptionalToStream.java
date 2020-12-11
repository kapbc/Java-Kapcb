package com.kapcb.ccc.practice.stream.optional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <a>Title: OptionalToStream </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-11:07
 */
public class OptionalToStream {

    public static void main(String[] args) {
        List<OptionalTestBean> userList = new ArrayList<>();
        userList.add(new OptionalTestBean(123, "kapcb", LocalDateTime.MIN, 14));
        userList.add(new OptionalTestBean(1233, "nb", LocalDateTime.MIN, 15));
        userList.add(new OptionalTestBean(1235, "!", LocalDateTime.MIN, 16));
        userList.add(new OptionalTestBean(1234, "aaa", LocalDateTime.MIN, 17));
        userList.add(new OptionalTestBean(1234, "bbb", LocalDateTime.MIN, 54));
        userList.add(new OptionalTestBean(1234, "ddd", LocalDateTime.MIN, 32));

        List<String> optionalBeanStream = userList.stream().map(OptionalTestBean::lookup).filter(Optional::isPresent).map(Optional::get).map(OptionalTestBean::getName).collect(Collectors.toList());
        System.out.println(optionalBeanStream);

        /**
         * JDK 9
         */
        // userList.stream().map(UserBean::lookup).flatMap(Optional::stream);
    }
}
