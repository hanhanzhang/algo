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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT0210 {

    @SuppressWarnings("unchecked")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 记录每个节点的入度(即: 输入边数)
        int[] degree = new int[numCourses];
        // 记录每个节点出边(即: 每个节点输出边)
        List<Integer>[] edges = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
            edges[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        // 选修课程
        int[] ans = new int[numCourses];
        // 入度为零即无依赖课程, 则入队列
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int course = queue.remove();
                size -= 1;
                ans[index++] = course;
                // 下游节点的入度减一
                List<Integer> neighbours = edges[course];
                for (Integer neighbour : neighbours) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        return index == numCourses ? ans : new int[0];
    }

    public static void main(String[] args) {
        LT0210 lt = new LT0210();
        ArrayUtils.printArray(lt.findOrder(2, new int[][]{{1, 0}}));
    }

}
