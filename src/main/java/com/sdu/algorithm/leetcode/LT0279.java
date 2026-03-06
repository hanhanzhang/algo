package com.sdu.algorithm.leetcode;

public class LT0279 {


    public int numSquares(int n) {
        // 递归方式: 运行超时, 则用空间换时间
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LT0279 lt = new LT0279();
        System.out.println(lt.numSquares(58));
    }

}
