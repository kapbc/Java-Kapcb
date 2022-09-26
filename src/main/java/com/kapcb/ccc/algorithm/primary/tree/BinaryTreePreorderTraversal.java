package com.kapcb.ccc.algorithm.primary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <a>Title: BinaryTreePreorderTraversal </a>
 * <a>Description: 二叉树前序遍历 <a>
 * <a href="https://www.nowcoder.com/practice/5e2135f4d2b14eb8a5b06fab4c938635?tpId=295&tqId=2291302&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author kapcb
 * @version 1.0
 * @date 2022/9/8 10:05
 * @since 1.0
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(3, new TreeNode(1), new TreeNode(2)), new TreeNode(6, new TreeNode(5), new TreeNode(6)));
        int[] ints = preorderTraversal(treeNode);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.empty()) {
                root = stack.pop();
                resList.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }

        }
        int[] res = new int[resList.size()];

        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /**
     * 递归方式实现二叉树
     *
     * @param root {@link TreeNode}
     * @return int[]
     */
    private static int[] preorderTraversalByRecursion(TreeNode root) {

        if (root == null) {
            return new int[]{};
        }

        List<Integer> values = new ArrayList<>();

        process(values, root);

        int n = values.size();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = values.get(i);
        }

        return res;

    }

    private static void process(List<Integer> values, TreeNode root) {

        if (root == null) {
            return;
        }

        values.add(root.val);

        process(values, root.left);
        process(values, root.right);

    }

}
