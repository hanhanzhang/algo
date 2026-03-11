package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0289 {

    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    private int count(int[][] grid, int x, int y) {
        int cnt = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }
            cnt += grid[nx][ny] == 1 || grid[nx][ny] == 2 ? 1 : 0;
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    int cnt = count(board, i, j);
                    if (cnt != 2 && cnt != 3) {     // 死亡
                        board[i][j] = 2;            // 表示之前是活细胞, 此轮已死
                    }
                } else if (board[i][j] == 0) {
                    int cnt = count(board, i, j);
                    if (cnt == 3) {
                        board[i][j] = 3;            // 表示之前是死细胞, 此轮已活
                    }
                }
            }
        }
        // 2 -> 0, 3 -> 1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        LT0289 lt = new LT0289();
        lt.gameOfLife(grid);
        ArrayUtils.printArray(grid);
    }
}
