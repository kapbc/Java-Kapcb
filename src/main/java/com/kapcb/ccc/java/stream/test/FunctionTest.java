package com.kapcb.ccc.java.stream.test;


import java.util.ArrayList;
import java.util.List;

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


    }

    private static class SimpleId {
        private Integer firstId;
        private Integer lastId;
        private List<SimpleId> listTo = new ArrayList<>();
        private List<SimpleId> listFrom = new ArrayList<>();

        public SimpleId() {
        }

        public SimpleId(Integer firstId, Integer lastId) {
            this.firstId = firstId;
            this.lastId = lastId;
        }

        public Integer getFirstId() {
            return firstId;
        }

        public void setFirstId(Integer firstId) {
            this.firstId = firstId;
        }

        public Integer getLastId() {
            return lastId;
        }

        public void setLastId(Integer lastId) {
            this.lastId = lastId;
        }

        public void addTo(SimpleId simpleId) {
            this.listTo.add(simpleId);
        }

        public SimpleId getTo(int index) {
            return this.listTo.get(index);
        }

        public void addFrom(SimpleId simpleId) {
            this.listFrom.add(simpleId);
        }

        public SimpleId getFrom(int index) {
            return listFrom.get(index);
        }

        @Override
        public String toString() {
            return "SimpleId:[ firstId= " + this.firstId + ", lastId= " + this.lastId + " ]";
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
