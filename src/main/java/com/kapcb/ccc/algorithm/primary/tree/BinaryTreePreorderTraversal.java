package com.kapcb.ccc.algorithm.primary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: BinaryTreePreorderTraversal </a>
 * <a>Description: BinaryTreePreorderTraversal <a>
 * <a href="https://www.nowcoder.com/practice/5e2135f4d2b14eb8a5b06fab4c938635?tpId=295&tqId=2291302&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj">...</a>
 *
 * @version 1.0
 * @date 2022/9/8 10:05
 * @since 1.0
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {

    }

    private int[] preorderTraversal(TreeNode root) {

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
