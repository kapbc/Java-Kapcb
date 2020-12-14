package com.kapcb.ccc.java.stream.downcollector;

import com.kapcb.ccc.java.stream.api.City;
import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toSet;

/**
 * <a>Title: DownStreamCollectors </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-13:50
 */
public class DownStreamCollectors {

    private static final String filename = Constants.COMMON_CITY_TXT_RESOURCES_PATH.getStringStatusCode();

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename), StandardCharsets.UTF_8)
                .map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode()))
                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(Locale::getCountry, counting()));
        System.out.println("countryToLocaleCounts = " + countryToLocaleCounts);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(Locale::getCountry, toSet()));
        System.out.println("countryToLocaleSet = " + countryToLocaleSet);

        Stream<City> cities = readCities(filename);
        Map<String, IntSummaryStatistics> stateToCityPopulation = cities.collect(groupingBy(City::getState, summarizingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation = " + stateToCityPopulation);

        cities = readCities(filename);
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(groupingBy(City::getState, mapping(City::getName, maxBy(Comparator.comparing(String::length)))));
        System.out.println("stateToLongestCityName = " + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(groupingBy(Locale::getDisplayCountry, mapping(Locale::getDisplayLanguage, toSet())));
        System.out.println("countryToLanguages = " + countryToLanguages);

        cities = readCities(filename);
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(groupingBy(City::getState, summarizingInt(City::getPopulation)));
        System.out.println("stateToCityPopulationSummary NY = " + stateToCityPopulationSummary.get("NY"));

        cities = readCities(filename);
        Map<String, String> stateToCityNames = cities.collect(groupingBy(City::getState, reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s + ", " + t)));
        System.out.println("stateToCityNames = " + stateToCityNames);

        cities = readCities(filename);
        stateToCityNames = cities.collect(groupingBy(City::getState, mapping(City::getName, joining(", "))));
        System.out.println("stateToCityNames = " + stateToCityNames);

    }
}
