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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT0079 {

    private static boolean dfs(char[][] board, int i, int j, String word, int position, int[][] visited) {
        if (position >= word.length()) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        if (board[i][j] != word.charAt(position)) {
            // 还原, 防止对下个搜索方向的影响(回溯)
            visited[i][j] = 0;
            return false;
        }

        boolean ans = dfs(board, i - 1, j, word, position + 1, visited)
                || dfs(board, i + 1, j, word, position + 1, visited)
                || dfs(board, i, j - 1, word, position + 1, visited)
                || dfs(board, i, j + 1, word, position + 1, visited);

        if (!ans) {
            visited[i][j] = 0;
        }
        return ans;
    }

    private static boolean exist(char[][] board, String word) {
        Map<Character, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < board.length; ++i) {
            for (int k = 0; k < board[i].length; ++k) {
                List<int[]> positions = graph.computeIfAbsent(board[i][k], key -> new ArrayList<>());
                positions.add(new int[]{i, k});
            }
        }

        List<int[]> starts = graph.get(word.charAt(0));
        if (starts == null || starts.isEmpty()) {
            return false;
        }

        for (int[] start : starts) {
            int[][] visited = new int[board.length][board[0].length];
            if (dfs(board, start[0], start[1], word, 0, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

        char[][] board1 = new char[][]{
                {'a'}
        };
        System.out.println(exist(board1, "a"));

        char[][] board2 = new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        };
        System.out.println(exist(board2, "cdba"));
    }

}
