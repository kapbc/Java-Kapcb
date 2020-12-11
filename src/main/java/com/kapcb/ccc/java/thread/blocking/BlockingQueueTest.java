package com.kapcb.ccc.java.thread.blocking;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: BolckingQueueTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/7-14:27
 */
public class BlockingQueueTest {

    private static final int FILE_QUEUE_CAPACITY = 10;
    private static final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Paths.get("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_CAPACITY);

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Enter base directory (e.g. /opt/jdk-8-src): ");
            String directory = scanner.nextLine();
            System.out.println("Entry keyword (e.g. volatile) ");
            String keyword = scanner.nextLine();
            new Thread(() -> {
                try {
                    enumerates(Paths.get(directory));
                    queue.put(DUMMY);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, Constants.COMMON_THREAD_NAME_A.getStringStatusCode()).start();

            for (int i = 0; i < SEARCH_THREADS; i++) {
                new Thread(() -> {
                    boolean done = false;
                    while (!done) {
                        try {
                            Path take = null;
                            take = queue.take();
                            if (take == DUMMY) {
                                queue.put(take);
                                done = true;
                            } else {
                                search(take, keyword);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, Constants.COMMON_THREAD_NAME_B.getStringStatusCode()).start();
            }
        }
    }

    /**
     * Recursively enumerates all files in a given directory and its subdirectories
     *
     * @param directory Path
     * @throws InterruptedException InterruptedException
     * @throws IOException          IOException
     */
    public static void enumerates(Path directory) throws InterruptedException, IOException {
        try (Stream<Path> list = Files.list(directory);) {
            for (Path path : list.collect(Collectors.toList())) {
                if (Files.isDirectory(path)) {

                } else {
                    queue.put(path);
                }
            }
        }
    }

    /**
     * search a file for a given keyword and prints all matching lines
     *
     * @param file    Path
     * @param keyword String
     * @throws IOException IOException
     */
    public static void search(Path file, String keyword) throws IOException {
        try (Scanner scanner = new Scanner(file, String.valueOf(StandardCharsets.UTF_8));) {
            int lineNumber = 0;
            while (scanner.hasNext()) {
                lineNumber++;
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s: %d : %s%n", file, lineNumber, line);
                }
            }
        }
    }
}
