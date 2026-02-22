/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT417 {

    private static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int[][] moved = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        // 连通集问题
        int[][] pacific = new int[matrix.length][];
        int[][] atlantic = new int[matrix.length][];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; ++i) {
            pacific[i] = new int[matrix[i].length];
            atlantic[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i == 0 || j == 0) {
                    pacific[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
                if (i == matrix.length - 1 || j == matrix[i].length - 1) {
                    atlantic[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        List<List<Integer>> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            // 更新四个方向点, 若四个方向点有变化, 则需要进队列
            for (int i = 0; i < moved.length; ++i) {
                int[] move = moved[i];
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[x].length) {
                    continue;
                }
                if (matrix[newX][newY] >= matrix[x][y]) {
                    if (pacific[x][y] == 1 && atlantic[x][y] == 1) {
                        boolean change = false;
                        if (pacific[newX][newY] != 1) {
                            pacific[newX][newY] = 1;
                            change = true;
                        }
                        if (atlantic[newX][newY] != 1) {
                            atlantic[newX][newY] = 1;
                            change = true;
                        }
                        if (change)
                            queue.offer(new int[]{newX, newY});
                        continue;
                    }

                    if (pacific[x][y] == 1 && pacific[newX][newY] != 1) {
                        pacific[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});
                        continue;
                    }

                    if (atlantic[x][y] == 1 && atlantic[newX][newY] != 1) {
                        atlantic[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> location = new ArrayList<>();
                    location.add(i);
                    location.add(j);
                    ans.add(location);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> ans = pacificAtlantic(matrix);
        System.out.println(ans);

        int[][] matrix2 = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        List<List<Integer>> ans2 = pacificAtlantic(matrix2);
        System.out.println(ans2);
    }

}
