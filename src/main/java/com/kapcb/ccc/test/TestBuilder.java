package com.kapcb.ccc.test;

import com.kapcb.ccc.pattern.build.SolrUtil.SolrBuilder;

import java.util.HashSet;

/**
 * <a>Title: TestBuilder </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:15
 */
public class TestBuilder {

    public static void main(String[] args) {

        SolrBuilder solrBuilder = new SolrBuilder();
        String queryString = solrBuilder.field("kapcb", "awesome man")
                .filter("ccc", "nb")
                .params("factList", new HashSet<String>() {{
                    add("userId");
                    add("username");
                    add("password");
                    add("birthday");
                }})
                .field("123", "345")
                .builder();

        System.out.println("queryString = " + queryString);
    }
}
