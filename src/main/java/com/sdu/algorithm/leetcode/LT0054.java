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
import java.util.List;

public class LT0054 {

    private static List<Integer> spiralOrder(int[][] matrix) {
        // 方向
        int total = matrix.length * matrix[0].length;
        int[][] moved = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        List<Integer> ans = new ArrayList<>();
        int x = 0, y = 0, pos = 0;

        while (ans.size() != total) {
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length || visited[x][y]) {
                // 还原并转方向
                x -= moved[pos][0];
                y -= moved[pos][1];
                pos = ++pos % 4;
                x += moved[pos][0];
                y += moved[pos][1];
                continue;
            }

            visited[x][y] = true;
            ans.add(matrix[x][y]);

            x += moved[pos][0];
            y += moved[pos][1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };
        System.out.println(spiralOrder(matrix));
    }

}
