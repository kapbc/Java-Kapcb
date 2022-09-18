package com.kapcb.ccc.algorithm.primary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a>Title: BinaryTreeLevelOrder </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BinaryTreeLevelOrder <a>
 * <a href="https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=295&tqId=644&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/8 10:11 PM
 * @since 1.0
 */
public class BinaryTreeLevelOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write code here

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> treeNodesQueue = new ArrayDeque<>();

        treeNodesQueue.add(root);

        while (!treeNodesQueue.isEmpty()) {

            List<Integer> values = new ArrayList<>();

            int n = treeNodesQueue.size();

            for (int i = 0; i < n; i++) {

                TreeNode treeNode = treeNodesQueue.poll();

                values.add(treeNode.val);

                if (treeNode.left != null) {
                    treeNodesQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodesQueue.add(treeNode.right);
                }

            }

            res.add(values);

        }

        return res;

    }

}
