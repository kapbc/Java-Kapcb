package com.kapcb.ccc.code.io.zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * <a>Title: ZipTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-14:37
 */
public class ZipTest {

    public static void main(String[] args) throws IOException {
        String zipName = args[0];
        showContents(zipName);
        System.out.println("---");
//        showContentTwo(zipName);
    }

    /**
     * classic zip API
     *
     * @param zipName String
     * @throws IOException IOException
     */
    public static void showContents(String zipName) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipName))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());
                Scanner scanner = new Scanner(zipInputStream);
                while (scanner.hasNextLine()) {
                    System.out.println("    " + scanner.nextLine());
                }
                zipInputStream.closeEntry();
            }
        }
    }

    /**
     * nu classic zip API
     *
     * @param zipName String
     */
//    public static void showContentTwo(String zipName) throws IOException {
//        FileSystem fileSystem = FileSystems.newFileSystem(Paths.get(zipName));
//        Files.walkFileTree(fileSystem.getPath("/"), new SimpleFileVisitor<Path>() {
//            public FileVisitResult visitResult(Path path, BasicFileAttributes attributes) throws IOException {
//                System.out.println(path);
//                for (String readAllLine : Files.readAllLines(path, Charset.forName("UTF-8"))) {
//                    System.out.println("    " + readAllLine);
//                }
//                return FileVisitResult.CONTINUE;
//            }
//        });
//    }
}
