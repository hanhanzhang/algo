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

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0059 {

    private static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 定义方向
        int[][] moved = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0, i = 0, j = 0;
        int num = 1;
        while (num <= n * n) {
            if (i < 0 || i >= n || j < 0 || j >= n || res[i][j] != 0) {
                // 还原 -> 调向
                int[] move = moved[index];
                i = i - move[0];
                j = j - move[1];
                index = (index + 1) % 4;
                move = moved[index];
                i = i + move[0];
                j = j + move[1];
                continue;
            }
            res[i][j] = num;
            num += 1;
            int[] move = moved[index];
            i = i + move[0];
            j = j + move[1];
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayUtils.printArray(generateMatrix(3));
        ArrayUtils.printArray(generateMatrix(1));
    }

}
