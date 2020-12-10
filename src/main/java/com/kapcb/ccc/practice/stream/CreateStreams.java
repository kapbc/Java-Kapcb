package com.kapcb.ccc.practice.stream;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


/**
 * <a>Title: CreateStreams </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/10-8:49
 */
public class CreateStreams {

    private static final Logger logger = Logger.getLogger(String.valueOf(CreateStreams.class)
            , Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static <T> void show(String title, Stream<T> stream) {
        final int size = 10;
        List<T> firstElement = stream.limit(size + 1).collect(Collectors.toList());
        System.out.println(title + ": ");
        for (int i = 0; i < firstElement.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            if (i < size) {
                System.out.print(firstElement.get(i));
            } else {
                System.out.print("....");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(Constants.COMMON_STREAM_TEST_TXT_RESOURCES_PATH.getStringStatusCode());

        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("word", words);

        Stream<String> silence = Stream.empty();
        show("silence", silence);

        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("iterate", iterate);


        try (Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents)) {
            show("wordsAnotherWay", wordsAnotherWay);
        } catch (Exception e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_INFO.getStringStatusCode() + e
                    + Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE.getStringStatusCode() + e.getMessage());
        }

        try (Stream<String> lines = Files.lines(path);) {
            show("lines", lines);
        }

        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectories = StreamSupport.stream(iterable.spliterator(), false);
        show("rootDirectories", rootDirectories);
        Iterator<Path> iterator = path.iterator();
        Stream<Path> pathComponents = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        show("pathComponents", pathComponents);
    }
}
