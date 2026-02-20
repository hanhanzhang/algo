package com.sdu.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LT0994 {

  public int orangesRotting(int[][] grid) {
      // 广度优先算法
      Queue<Integer> queue = new LinkedList<>();
      int fresh = 0;
      int row = grid.length, col = grid[0].length;
      for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
              if (grid[i][j] == 1) {
                  fresh++;
              } else if (grid[i][j] == 2) {
                  queue.offer(i * col + j);
              }
          }
      }

      if (fresh == 0) {
          return 0;
      }

      int[][] pos = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      int time = 0;
      while (!queue.isEmpty() && fresh > 0) {
          time += 1;
          int size = queue.size();
          while (size > 0) {
              int index =  queue.remove();
              int x = index / col, y = index % col;
              for (int i = 0; i < 4; i++) {
                  int nx = x + pos[i][0];
                  int ny = y + pos[i][1];
                  if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                      grid[nx][ny] = 2;
                      queue.offer(nx * col + ny);
                      fresh--;
                  }
              }
              size -= 1;
          }

      }

      return fresh == 0 ? time : -1;
  }

  public static void main(String[] args) {
    int[][] grid0 = new int[][] {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };

    int[][] grid1 = new int[][] {
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
    };

    int[][] grid2 = new int[][] {
        {0, 2},
    };

    int[][] grid3 = new int[][] {
        {1, 2, 1, 1, 2, 1, 1}
    };

    int[][] grid4 = new int[][] {
        {2, 2},
        {1, 1},
        {0, 0},
        {2, 0}
    };

    int[][] grid5 = new int[][] {
        {0}
    };

    LT0994 lt = new LT0994();
    System.out.println(lt.orangesRotting(grid0));
    System.out.println(lt.orangesRotting(grid1));
    System.out.println(lt.orangesRotting(grid2));
    System.out.println(lt.orangesRotting(grid3));
    System.out.println(lt.orangesRotting(grid4));
    System.out.println(lt.orangesRotting(grid5));
  }

}
