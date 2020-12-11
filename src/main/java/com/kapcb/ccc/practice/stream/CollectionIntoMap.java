package com.kapcb.ccc.practice.stream;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: CollectionIntoMap </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11-15:34
 */
public class CollectionIntoMap {

    public static void main(String[] args) {

        Map<Integer, String> resultMap = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("resultMap = " + resultMap);

        Map<Integer, Person> resultPersonMap = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("resultPersonMap = " + resultPersonMap);

        TreeMap<Integer, Person> treeMapResult = people().collect(Collectors.toMap(Person::getId, Function.identity(), (oldValue, newValue) -> {
            throw new IllegalStateException();
        }, TreeMap::new));
        System.out.println("treeMapResult = " + treeMapResult);

        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> localeMapResult = availableLocales.collect(Collectors.toMap(Locale::getDisplayLanguage, locale -> locale.getDisplayLanguage(locale), (oldValue, newValue) -> oldValue));
        System.out.println("localeMapResult = " + localeMapResult);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> collect = locales.collect(Collectors.toMap(Locale::getDisplayCountry, locale -> Collections.singleton(locale.getDisplayLanguage()), (oldValue, newValue) -> {
            HashSet<String> set = new HashSet<>(newValue);
            // set.addAll(newValue);
            return set;
        }));
        System.out.println("collect = " + collect);

        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> groupResultMap = localeStream.collect(Collectors.groupingBy(Locale::getCountry));
        System.out.println("groupResultMap = " + groupResultMap);
        List<Locale> ch = groupResultMap.getOrDefault("CH", null);
        System.out.println("ch = " + ch);
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "kapcb"), new Person(1002, "ccc"), new Person(1003, "demo"));
    }

    public static class Person {
        private int id;
        private String name;

        public Person() {
        }

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person [ id= " + id + ", name= " + name + " ]";
        }
    }
}
