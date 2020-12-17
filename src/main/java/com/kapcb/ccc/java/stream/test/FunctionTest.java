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
import java.util.function.Consumer;
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
            lines.map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String test = "eircccallroot@163.com, eircccallroot@yeah.net";
        String testTwo = "eircccallroot@163.com|eircccallroot@yeah.net, chenchengcheng@163.com|eircccallroot@126.com";

        Menu menu = new Menu();
        addIntoMenu(testTwo, menu::addTo);
        System.out.println("menu.getTo() = " + menu.getTo());
        addIntoMenu(test, menu::addFrom);
        System.out.println("menu.getFrom() = " + menu.getFrom());
    }

    private static void addIntoMenu(String address, Consumer<SimpleAddress> consumer) {
        if (address.contains(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())) {
            Stream
                    .of(address)
                    .map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode()))
                    .flatMap(Arrays::stream)
                    .map(FunctionTest::getSimpleAddress)
                    .forEach(consumer);
        } else {
            consumer.accept(getSimpleAddress(address));
        }

    }

    private static SimpleAddress getSimpleAddress(String ids) {
        if (ids.contains(Constants.COMMON_STRING_SPLIT_VERTICAL_LINE.getStringStatusCode())) {
            return Stream
                    .of(ids)
                    .map(s -> s.split(Constants.COMMON_STRING_SPLIT_ESCAPE_VERTICAL_LINE.getStringStatusCode()))
                    .map(e -> new SimpleAddress(e[0], e[1]))
                    .findAny()
                    .orElseGet(null);
        }
        return new SimpleAddress(ids, ids);
    }

    private static class SimpleAddress {
        private String firstAddress;
        private String lastAddress;

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

        public SimpleAddress(String firstAddress, String lastAddress) {
            this.firstAddress = firstAddress;
            this.lastAddress = lastAddress;
        }

        @Override
        public String toString() {
            return "SimpleAddress:[ firstAddress= " +
                    this.firstAddress +
                    ", lastAddress= " +
                    this.lastAddress +
                    " ]";
        }
    }

    private static class Menu {
        private Integer parentId;
        private Integer nodeId;
        private String menuName;
        private int order;

        private List<SimpleAddress> listTo = new ArrayList<>();
        private List<SimpleAddress> listFrom = new ArrayList<>();

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

        public void addTo(SimpleAddress simpleAddress) {
            this.listTo.add(simpleAddress);
        }

        public List<SimpleAddress> getTo() {
            return this.listTo;
        }

        public void addFrom(SimpleAddress simpleAddress) {
            this.listFrom.add(simpleAddress);
        }

        public List<SimpleAddress> getFrom() {
            return listFrom;
        }

        @Override
        public String toString() {
            return "Menu:[parentId= " + this.parentId +
                    " ,nodeId= " + this.nodeId +
                    ", menuName= " + this.menuName +
                    ", order= " + this.order +
                    ", listTo= " + this.listTo +
                    ", ListFrom= " + this.listFrom +
                    "]";
        }
    }
}
