package com.kapcb.ccc.java.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * <a>Title: FindDirectories </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-16:28
 */
public class FindDirectories {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(args.length == 0 ? System.getProperty("user.home") : args[0]);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitResult(Path file, BasicFileAttributes attributes) {
                if (attributes.isDirectory()) {
                    System.out.println(file);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException e) {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
