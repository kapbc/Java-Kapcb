package com.kapcb.ccc.algorithm.primary.tree;

/**
 * <a>Title: RebuildBinaryTree </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RebuildBinaryTree <a>
 * 已知一个搜索二叉树后序遍历的数组posArr，请根据posArr，重建出整棵树，返回新建树的头节点
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/7 9:29 PM
 * @since 1.0
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {

        int[] posArr = {1, 3, 2, 7, 9, 8, 6};
        TreeNode treeNode = proArr2BST1(posArr);
        System.out.println("node = " + treeNode);

        TreeNode treeNode1 = proArr2BST2(posArr);
        System.out.println("node1 = " + treeNode1);
    }

    private static TreeNode proArr2BST1(int[] posArr) {

        if (posArr == null || posArr.length < 1) {
            return null;
        }

        return process1(posArr, 0, posArr.length - 1);

    }

    private static TreeNode proArr2BST2(int[] posArr) {
        if (posArr == null || posArr.length < 1) {
            return null;
        }

        return process2(posArr, 0, posArr.length - 1);

    }


    private static TreeNode process1(int[] posArr, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode head = new TreeNode(posArr[r]);

        if (l == r) {
            return head;
        }

        // 兼顾搜索二叉树为全部为左子节点和全部为右子节点的情况
        int m = l - 1;
        for (int i = l; i < r; i++) {
            if (posArr[i] < posArr[r]) {
                m = i;
            }
        }

        head.left = process1(posArr, l, m);
        head.right = process1(posArr, m + 1, r - 1);
        return head;
    }

    private static TreeNode process2(int[] posArr, int l, int r) {

        if (l > r) {
            return null;
        }

        TreeNode head = new TreeNode(r);

        if (l == r) {
            return head;
        }

        int m = l - 1;
        int left = l;
        int right = r - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (posArr[mid] < posArr[r]) {
                m = mid;
                left = ++mid;
            } else {
                right = --mid;
            }
        }

        head.left = process2(posArr, l, m);
        head.right = process2(posArr, m + 1, r - 1);

        return head;

    }

}
