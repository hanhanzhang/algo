package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0073 {

    public void setZeroes(int[][] matrix) {
        // 常规思路: 筛选出需要置零的行和列, 需要两个数组记录
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        LT0073 lt = new LT0073();
        lt.setZeroes(matrix);
        ArrayUtils.printArray(matrix);
    }

}
