package com.kapcb.ccc.algorithm.primary.tree;

/**
 * <a>Title: TreeNode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: TreeNode <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/18 10:10 PM
 * @since 1.0
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
