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

package com.sdu.algorithm.offercode;

public class OR012 {

    private static boolean dfs(char[][] board, int x, int y, String word, int index, int[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length
                || visited[x][y] == 1 || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = 1;
        boolean ret = dfs(board, x + 1, y, word, index + 1, visited)
                || dfs(board, x - 1, y, word, index + 1, visited)
                || dfs(board, x, y + 1, word, index + 1, visited)
                || dfs(board, x, y - 1, word, index + 1, visited);
        if (!ret) {
            visited[x][y] = 0;
        }
        return ret;
    }

    private static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        char ch = word.charAt(0);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == ch) {
                    boolean ans = dfs(board, i, j, word, 0, new int[board.length][board[0].length]);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board1, "ABCCED"));

        char[][] board2 = new char[][]{
                {'A', 'B'},
                {'C', 'D'}
        };
        System.out.println(exist(board2, "abcd"));
    }

}
