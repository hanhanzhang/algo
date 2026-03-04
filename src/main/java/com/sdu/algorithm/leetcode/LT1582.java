package com.sdu.algorithm.leetcode;

public class LT1582 {

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowsSum[i] += mat[i][j];
                colsSum[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {0,0,1,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,1,0,0}
        };
        LT1582 lt = new LT1582();
        System.out.println(lt.numSpecial(mat));
    }

}
