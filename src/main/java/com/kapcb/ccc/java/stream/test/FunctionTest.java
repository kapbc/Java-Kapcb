package com.kapcb.ccc.java.stream.test;


import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <a>Title: FunctionTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/17-14:58
 */
public class FunctionTest {

    public static void main(String[] args) {
        Path path = Paths.get(Constants.COMMON_MENU_TXT_RESOURCES_PATH.getStringStatusCode());
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);) {
            lines.map(s -> s.split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String test = "eircccallroot@163.com,eircccallroot@yeah.net";
        String testTwo = "eircccallroot@163.com,eircccallroot@yeah.net|chenchengcheng@163.com,eircccallroot@126.com";
        Stream.of(testTwo).map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).flatMap(Arrays::stream).forEach();

    }

    private static SimpleAddress getSimpleId(String ids) {
        if (ids.contains("|")) {
            return Stream.of(ids).map(s -> s.split("|")).map(e -> new SimpleAddress(e[0], e[1])).findAny().orElseGet(null);
        }
        new SimpleAddress()
    }

    private static class SimpleAddress {
        private String firstAddress;
        private String lastAddress;
        private List<SimpleAddress> listTo = new ArrayList<>();
        private List<SimpleAddress> listFrom = new ArrayList<>();

        public SimpleAddress() {
        }

        public String getFirstAddress() {
            return firstAddress;
        }

        public void setFirstAddress(String firstAddress) {
            this.firstAddress = firstAddress;
        }

        public String getLastAddress() {
            return lastAddress;
        }

        public void setLastAddress(String lastAddress) {
            this.lastAddress = lastAddress;
        }

        public List<SimpleAddress> getListTo() {
            return listTo;
        }

        public void setListTo(List<SimpleAddress> listTo) {
            this.listTo = listTo;
        }

        public List<SimpleAddress> getListFrom() {
            return listFrom;
        }

        public void setListFrom(List<SimpleAddress> listFrom) {
            this.listFrom = listFrom;
        }

        public SimpleAddress(String firstAddress, String lastAddress) {
            this.firstAddress = firstAddress;
            this.lastAddress = lastAddress;
        }

        public void addTo(SimpleAddress simpleAddress) {
            this.listTo.add(simpleAddress);
        }

        public SimpleAddress getTo(int index) {
            return this.listTo.get(index);
        }

        public void addFrom(SimpleAddress simpleAddress) {
            this.listFrom.add(simpleAddress);
        }

        public SimpleAddress getFrom(int index) {
            return listFrom.get(index);
        }

        @Override
        public String toString() {
            return "SimpleAddress:[ firstAddress= " + this.firstAddress + ", lastAddress= " + this.lastAddress + " ]";
        }
    }

    private static class Menu {
        private Integer parentId;
        private Integer nodeId;
        private String menuName;
        private int order;

        public Menu() {
        }

        public Menu(Integer parentId, Integer nodeId, String menuName, int order) {
            this.parentId = parentId;
            this.nodeId = nodeId;
            this.menuName = menuName;
            this.order = order;
        }


        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public Integer getNodeId() {
            return nodeId;
        }

        public void setNodeId(Integer nodeId) {
            this.nodeId = nodeId;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "Menu:[parentId= " + this.parentId
                    + " ,nodeId= " + this.nodeId +
                    ", menuName= " + this.menuName +
                    ", order= " + this.order + " ]";
        }
    }
}
