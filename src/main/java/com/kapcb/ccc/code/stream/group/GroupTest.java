package com.kapcb.ccc.code.stream.group;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: GroupTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-9:53
 */
public class GroupTest {

    public static void main(String[] args) {
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> collect = availableLocales.collect(Collectors.groupingBy(Locale::getCountry));
        List<Locale> ch = collect.get("CH");
        System.out.println(ch);

        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishLocales = localeStream.collect(Collectors.partitioningBy(l -> l.getLanguage().equalsIgnoreCase("en")));
        List<Locale> locales = englishLocales.get(true);
        System.out.println(locales);
    }
}
