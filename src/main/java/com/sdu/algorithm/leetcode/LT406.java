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
import java.util.Arrays;
import java.util.List;

public class LT406 {

    private static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        // 核心思想: 个高排在前面
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                // 按照K排序
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });

        // 调整顺序
        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            int k = p[1];
            if (k <= ans.size()) {
                ans.add(k, p);
            } else {
                ans.add(p);
            }
        }

        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = reconstructQueue(people);

        for (int[] res : ans) {
            StringBuilder sb = new StringBuilder();
            for (int element : res) {
                sb.append(element).append(" ");
            }
            System.out.println(sb.toString());
        }
        System.out.println("************");
    }

}
