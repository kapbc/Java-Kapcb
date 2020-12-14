package com.kapcb.ccc.java.stream;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toSet;

/**
 * <a>Title: DownStreamCollector </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-10:09
 */
public class DownStreamCollector {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(Constants.COMMON_CITY_TXT_RESOURCES_PATH.getStringStatusCode());
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> collect = availableLocales.collect(groupingBy(Locale::getCountry, toSet()));

        Stream<Locale> defaultLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToTotalCounts = defaultLocales.collect(groupingBy(Locale::getCountry, counting()));
        Long ch = countryToTotalCounts.get("CH");
        System.out.println(ch);

        Stream<City> cityStream = Files.lines(path).map(l -> l.split(", ")).map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
        Map<String, IntSummaryStatistics> stateToCityPopulation = cityStream.collect(groupingBy(City::getState, summarizingInt(City::getPopulation)));
        // stateToCityPopulation.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
        IntSummaryStatistics de = stateToCityPopulation.get("DE");
        System.out.println(de.getSum());

        Stream<City> cityStreamOne = Files.lines(path).map(line -> line.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).map(city -> new City(city[0], city[1], Integer.parseInt(city[2])));
        Map<String, Optional<City>> stateToLargestCity = cityStreamOne.collect(groupingBy(City::getState, maxBy(Comparator.comparingInt(City::getPopulation))));
        // stateToLargestCity.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
        Optional<City> tx = stateToLargestCity.get("TX");
        System.out.println(tx.orElse(null));

        // Stream<City> cityStreamTwo = Files.lines(path).map(element -> element.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).map(line -> new City(line[0], line[1], Integer.parseInt(line[2])));
        Stream<String> lines = Files.lines(Paths.get(Constants.COMMON_STREAM_TEST_TXT_RESOURCES_PATH.getStringStatusCode()), StandardCharsets.UTF_8);
        Map<Character, Integer> characterIntegerMap = lines.collect(groupingBy(s -> s.charAt(0), collectingAndThen(toSet(), Set::size)));
        characterIntegerMap.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
    }
}
