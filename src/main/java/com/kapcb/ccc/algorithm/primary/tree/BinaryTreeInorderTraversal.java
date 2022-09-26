package com.kapcb.ccc.algorithm.primary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title: BinaryTreeInorderTraversal </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BinaryTreeInorderTraversal <a>
 * <a href="https://www.nowcoder.com/practice/0bf071c135e64ee2a027783b80bf781d?tpId=295&tqId=1512964&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/9/8 9:56 PM
 * @since 1.0
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(3, null, null)), null);
        int[] ints = inorderTraversalByRecursion(treeNode);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] inorderTraversalByRecursion(TreeNode root) {
        // write code here

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

        process(values, root.left);
        values.add(root.val);
        process(values, root.right);
    }

}
