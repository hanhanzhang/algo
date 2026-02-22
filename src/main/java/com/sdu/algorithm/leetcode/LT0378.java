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

import java.util.PriorityQueue;

public class LT0378 {

    public int kthSmallest(int[][] matrix, int k) {
        // 归并排序, 借助优先级队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }
        int col = matrix[0].length;
        for (int i = 1; i <= k - 1; i++) {
            int[] element = queue.poll();
            if (element[2] != col - 1) {
                int row = element[1];
                int newCol = element[2] + 1;
                queue.offer(new int[]{matrix[row][newCol], row, newCol});
            }
        }
        return queue.poll()[0];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        LT0378 lt = new LT0378();
        System.out.println(lt.kthSmallest(matrix, 8));
    }

}
