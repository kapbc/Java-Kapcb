package com.kapcb.ccc.code.collection;

import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Logger;

/**
 * <a>Title: UnModifiableViewTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/11/20-9:56
 */
public class UnModifiableViewTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(UnModifiableViewTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {
        Collection<String> strings = Collections.unmodifiableCollection(new ArrayList<String>());
        List<String> linkedListString = Collections.unmodifiableList(new LinkedList<String>());
        Set<String> hashSetString = Collections.unmodifiableSet(new HashSet<String>());
        SortedSet<String> treeSetString = Collections.unmodifiableSortedSet(new TreeSet<String>());
        NavigableSet<String> navigableTreeSetString = Collections.unmodifiableNavigableSet(new TreeSet<String>());
        Map<String, String> hashMapString = Collections.unmodifiableMap(new HashMap<String, String>(4));
        SortedMap<String, String> sortedMapString = Collections.unmodifiableSortedMap(new TreeMap<String, String>());
        NavigableMap<String, String> navigableTreeMapString = Collections.unmodifiableNavigableMap(new TreeMap<String, String>());
        
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String, String>(4));

        try {
            hashMapString.put("kapcb", "ccc");
        } catch (UnsupportedOperationException e) {
            logger.warning("kapcb.unmodifiable.collection");
        }
        hashMapString.forEach((k, v) -> System.out.println("k =" + k + ", v =" + v));
    }
}
