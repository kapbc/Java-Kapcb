package com.kapcb.ccc.code.reflect.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: ReflectForResultMap </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28-16:09
 */
public class ReflectForResultMap {

    public static void main(String[] args) throws Exception {

        Map<String, String> resultMap = new HashMap<>(10);
        resultMap.put("user_name", "kapcb");
        resultMap.put("pass_word", "123456");
        resultMap.put("l_upd_date", "2020-11-21 14:41:06:612");

        ResultMapping<Person> personResultMapping = new ResultMapping<>(Person.class);
        Person person = personResultMapping.resultMapper(resultMap);
        System.out.println("person = " + person);

    }

}
