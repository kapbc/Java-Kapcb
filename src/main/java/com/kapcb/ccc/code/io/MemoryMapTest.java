package com.kapcb.ccc.code.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * <a>Title: MemoryMapTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 * <p>
 * computes CRC checksum of a file in four ways
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/18-15:36
 */
public class MemoryMapTest {

    public static void main(String[] args) throws IOException {

        System.out.println("Input Stream: ");
        long start = System.currentTimeMillis();
        Path pathname = Paths.get(args[0]);
        long crcValue = checkSumInputStream(pathname);
        long end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");

        System.out.println("Buffered Input Stream: ");
        start = System.currentTimeMillis();
        crcValue = checkSumBufferedInputStream(pathname);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");

        System.out.println("Random Access File: ");
        start = System.currentTimeMillis();
        crcValue = checkSumRandomAccessFile(pathname);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");

        System.out.println("Mapped File： ");
        start = System.currentTimeMillis();
        crcValue = checkSumMappedFile(pathname);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start) + " milliseconds");
    }

    private static long checkSumInputStream(Path filename) throws IOException {
        try (InputStream inputStream = Files.newInputStream(filename)) {
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = inputStream.read()) != -1) {
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    private static long checkSumBufferedInputStream(Path filename) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(filename))) {
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }


    private static long checkSumRandomAccessFile(Path filename) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename.toFile(), "r");) {
            long length = randomAccessFile.length();
            CRC32 crc32 = new CRC32();
            for (long i = 0; i < length; i++) {
                randomAccessFile.seek(i);
                int c = randomAccessFile.readByte();
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    private static long checkSumMappedFile(Path filename) throws IOException {
        try (FileChannel fileChannel = FileChannel.open(filename)) {
            CRC32 crc32 = new CRC32();
            int length = (int) fileChannel.size();
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);

            for (int i = 0; i < length; i++) {
                int c = buffer.get(i);
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }
}
