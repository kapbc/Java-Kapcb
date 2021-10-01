package com.kapcb.ccc.code.stream.primitive;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <a>Title: PrimitiveTypeStreams </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14-16:40
 */
public class PrimitiveTypeStreams {

    public static void show(String title, IntStream stream) {
        final int size = 10;
        int[] firstElements = stream.limit(size + 1).toArray();
        System.out.println(title + ": ");
        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            if (i < size) {
                System.out.print(firstElements[i]);
            } else {
                System.out.print("...");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        IntStream is1 = IntStream.generate(() -> random.nextInt(100));
        show("is1", is1);

        IntStream is2 = IntStream.range(5, 10);
        show("is2", is2);

        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3", is3);

        Path path = Paths.get(Constants.COMMON_ALICE_TXT_RESOURCES_PATH.getStringStatusCode());
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        IntStream is4 = Stream.of(contents).mapToInt(String::length);
        show("is4", is4);

        String sentence = "\uD835\uDD46 is the set of octonions.";
        System.out.println("sentence = " + sentence);

        IntStream codes = sentence.codePoints();
        System.out.println(codes.mapToObj(c -> String.format("%X", c)).collect(Collectors.joining(", ")));

        Stream<Integer> integerStream = IntStream.range(0, 100).boxed();
        IntStream is5 = integerStream.mapToInt(Integer::intValue);
        show("is5", is5);
    }
}
