package com.sdu.algorithm.leetcode;

import java.util.List;

public class LT0310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return null;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };
        LT0310 lt = new LT0310();
        System.out.println(lt.findMinHeightTrees(6, edges));
    }

}
