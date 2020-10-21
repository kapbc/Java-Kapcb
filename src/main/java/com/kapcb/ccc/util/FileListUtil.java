package com.kapcb.ccc.util;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <a>Title:FileList</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.2
 * @date 2020/10/20 20:19
 */
public class FileListUtil {

    private static final String PATH_NAME = "D:\\filelist.txt";
    private static final String FILE_LIST_LOCATION_HEARD = "enigma3/";
    private static final String ILLEGAL_CHARACTERS = "\\\\";
    private static final String ILLEGAL_CHARACTERS_REPLACEMENT = "/";
    private static final String LINE_BREAK_REGEX = "\n";
    private static final String READ_MODE = "r";
    private static final int INITIAL_CAPACITY = 1024 * 5;

    private FileListUtil() {
    }

    public static TreeMap<Integer, Set<String>> getFileList(String pathName) {
        if ("".equals(pathName)) {
            pathName = PATH_NAME;
        }
        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;
        TreeMap<Integer, Set<String>> packageMap = null;
        try {
            randomAccessFile = new RandomAccessFile(pathName, READ_MODE);
            channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(INITIAL_CAPACITY);
            while (channel.read(byteBuffer) != -1) {
                int position = byteBuffer.position();
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                String str = new String(bytes, 0, position);
                if (str.contains(ILLEGAL_CHARACTERS)) {
                    str = str.replaceAll(ILLEGAL_CHARACTERS, ILLEGAL_CHARACTERS_REPLACEMENT);
                }
                String[] elementArray = str.split(LINE_BREAK_REGEX);
                packageMap = getPackageMap(elementArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return packageMap;
    }

    private static TreeMap<Integer, Set<String>> getPackageMap(String[] array) {
        TreeMap<Integer, Set<String>> map = new TreeMap<>();
        Set<String> treeSet = null;
        FileListStringCompare fileListStringCompare = new FileListStringCompare();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].startsWith(FILE_LIST_LOCATION_HEARD)) {
                StringBuilder stringBuilder = new StringBuilder(array[i]);
                stringBuilder.insert(0, FILE_LIST_LOCATION_HEARD);
                array[i] = stringBuilder.toString();
            }
            int Hierarchy = getPackageHierarchy(array[i]);
            if (!map.containsKey(Hierarchy)) {
                treeSet = new TreeSet<>(fileListStringCompare);
                treeSet.add(array[i]);
                map.put(Hierarchy, treeSet);
            } else {
                Set<String> strings = map.get(Hierarchy);
                strings.add(array[i]);
                map.put(Hierarchy,strings);
            }
        }
        return map;
    }

    public static int getPackageHierarchy(String location){
        return (location.split(ILLEGAL_CHARACTERS_REPLACEMENT).length-1);
    }
}


