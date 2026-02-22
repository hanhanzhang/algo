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

import java.util.LinkedList;
import java.util.Queue;

public class LT542 {

    private static int[][] updateMatrix(int[][] matrix) {
        int[][] moved = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < moved.length; ++i) {
                int[] m = moved[i];
                int x = point[0] + m[0];
                int y = point[1] + m[1];
                int val = matrix[point[0]][point[1]];
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length
                        || val + 1 >= matrix[x][y]) {
                    continue;
                }
                matrix[x][y] = val + 1;
                queue.offer(new int[]{x, y});
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] m = updateMatrix(matrix);
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
