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

import java.util.HashSet;
import java.util.Set;

public class LT547 {

    private static void dfs(int[][] M, int i, Set<Integer> visited) {
        if (i < 0 || i > M.length - 1) {
            return;
        }

        visited.add(i);
        for (int j = 0; j < M[i].length; ++j) {
            if (visited.contains(j)) {
                continue;
            }
            if (M[i][j] == 1) {
                dfs(M, j, visited);
            }
        }
    }

    private static int findCircleNum(int[][] M) {
        if (M == null)
            return 0;

        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < M.length; ++i) {
            if (visited.contains(i)) {
                continue;
            }
            ans += 1;
            dfs(M, i, visited);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[][] M1 = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        System.out.println(findCircleNum(M));
        System.out.println(findCircleNum(M1));
    }

}
