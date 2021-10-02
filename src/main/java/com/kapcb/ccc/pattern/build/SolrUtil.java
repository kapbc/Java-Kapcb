package com.kapcb.ccc.pattern.build;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a>Title: SolrUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-13:56
 */
public class SolrUtil {

    private static final Logger log = Logger.getLogger(String.valueOf(SolrUtil.class));

    private static final int INITIAL_CAPACITY = 16;
    private static final String DEFAULT_STRING_VALUE = "{}";

    private SolrUtil() {
    }

    public static class SolrBuilder {

        private final Map<String, Object> solrParam = new HashMap<>(INITIAL_CAPACITY);

        public SolrBuilder() {
        }

        public SolrUtil.SolrBuilder filter(String key, Object object) {
            solrParam.put(key, object);
            return this;
        }

        public SolrUtil.SolrBuilder params(String key, Set<String> set) {
            solrParam.put(key, set);
            return this;
        }

        public SolrUtil.SolrBuilder field(String key, String field) {
            solrParam.put(key, field);
            return this;
        }

        public String builder() {
            try {
                StringBuilder solrString = new StringBuilder();
                solrParam.forEach((k, v) -> {
                    solrString.append(k).append(":").append(v).append(" ");
                });
                return solrString.toString();
            } catch (Exception e) {
                log.log(Level.WARNING, "solr utils build error, the exception message is : " + e.getMessage());
            }
            return DEFAULT_STRING_VALUE;
        }
    }
}
