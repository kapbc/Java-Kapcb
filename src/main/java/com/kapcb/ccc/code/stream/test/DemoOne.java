package com.kapcb.ccc.code.stream.test;


import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <a>Title: DemoOne </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/14 - 20:40
 */
public class DemoOne {

    public static void main(String[] args) throws IOException {
        String filename = Constants.COMMON_MENU_TXT_RESOURCES_PATH.getStringStatusCode();
        Stream<Menu> menuNodeStream = Files.lines(Paths.get(filename), StandardCharsets.UTF_8).map(line -> line.split(", ")).map(m -> new Menu(Integer.parseInt(m[0]), Integer.parseInt(m[1]), m[2], Integer.parseInt(m[3])));
        List<Menu> menuList = menuNodeStream.collect(toList());
//        System.out.println("rootIdList = " + rootIdList);
//        System.out.println("rootIdList = " + rootIdList);
//        Stream<Menu> menuStream = Files.lines(Paths.get("src/main/resource/menu.txt"), StandardCharsets.UTF_8).map(line -> line.split(", ")).map(m -> new Menu(Integer.parseInt(m[0]), Integer.parseInt(m[1]), m[2], Integer.parseInt(m[3])));
//        List<Menu> nodeIdList = menuStream.filter(s -> !s.getParentId().equals(0)).collect(toList());
//        System.out.println("nodeIdList = " + nodeIdList);
//        List<Menu> treeNode = getTreeNode(rootIdList, nodeIdList);
//        System.out.println("treeNode = " + treeNode);

        List<Menu> treeNode = getTreeNode(menuList);
        System.out.println("treeNode = " + treeNode);
    }


    private static List<Menu> getTreeNode(List<Menu> rootIdList) {
        List<Menu> rootMenu = new ArrayList<>();
        rootIdList.forEach(s -> {
            if (s != null && s.getParentId().equals(0)) {
                rootMenu.add(s);
                return;
            }
            for (Menu menu : rootMenu) {
                if (s != null && s.getParentId().equals(menu.getNodeId())) {
                    menu.getChildMenu().add(s);
                }
            }
        });
        return rootMenu;
    }

    private static class Menu {
        private Integer parentId;
        private Integer nodeId;
        private String menuName;
        private int order;
        private List<Menu> childMenu = new ArrayList<>();

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

        public List<Menu> getChildMenu() {
            return childMenu;
        }

        public void setChildMenu(List<Menu> childMenu) {
            this.childMenu = childMenu;
        }

        @Override
        public String toString() {
            return "Menu =[ parentId=" + this.parentId + ", nodeId=" + this.nodeId + ", menuName=" + this.menuName + ", order=" + order + ", childMenu=" + this.childMenu + " ]";
        }
    }

}
