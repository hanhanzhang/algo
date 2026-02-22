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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT0056 {

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> ans = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (cur[1] >= intervals[i][0]) { // 可合并
                cur = new int[]{cur[0], Math.max(cur[1], intervals[i][1])};
            } else {
                ans.add(cur);
                cur = intervals[i];
            }
        }
        ans.add(cur);

        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        ArrayUtils.printArray(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        ArrayUtils.printArray(merge(new int[][]{{1, 4}, {2, 3}}));
    }

}
