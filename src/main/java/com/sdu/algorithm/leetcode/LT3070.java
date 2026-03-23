package com.sdu.algorithm.leetcode;

public class LT3070 {

    public int countSubmatrices(int[][] grid, int k) {
        // 按行遍历
        int col = grid[0].length, ans = 0;
        int[] colSum = new int[col];
        for (int[] ints : grid) {
            int sum = 0;
            for (int j = 0; j < col; ++j) {
                colSum[j] += ints[j];
                sum += colSum[j];
                if (sum <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LT3070 lt = new LT3070();
        System.out.println(lt.countSubmatrices(
                new int[][] {
                        {7,2,9},
                        {1,5,0},
                        {2,6,6}
                },
                20
        ));
    }

}
