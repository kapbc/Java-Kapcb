package com.kapcb.ccc.algorithm.primary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: Test </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Test <a>
 * <a href="https://www.nowcoder.com/practice/1291064f4d5d4bdeaefbf0dd47d78541?tpId=295&tqId=2291301&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/7 11:13 PM
 * @since 1.0
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        int[] ints = postorderTraversal(null);
        System.out.println("ints = " + ints);
    }

    private static int[] postorderTraversal(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> nodeList = new ArrayList<>();

        tree2List(nodeList, root);

        int n = nodeList.size();

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = nodeList.get(i);
        }

        return res;
    }

    private static void tree2List(List<Integer> nodeList, TreeNode root) {

        if (root == null) {
            return;
        }

        tree2List(nodeList, root.left);
        tree2List(nodeList, root.right);

        nodeList.add(root.val);

    }

}
