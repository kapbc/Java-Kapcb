package com.kapcb.ccc.algorithm.leetcode.secondary;

import com.kapcb.ccc.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * <a>Title: Permutations </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/11 - 22:39
 * <p>
 * <p>
 * link: https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

    private static final Logger logger = Logger.getLogger(String.valueOf(Permutations.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {

    }

    private static List<List<Integer>> permute(List<Integer> list) {
        if (list.size() < 0) {
            logger.warning("kapcb.start.up.fail");
            return null;
        }
        int size = list.size();
        int[][] result = new int[size * 2][size];
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size * 2; j++) {
                while (count < 2) {
                // todo
                }
            }
        }
        return null;
    }
}
