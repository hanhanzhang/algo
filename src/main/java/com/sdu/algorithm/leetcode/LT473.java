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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LT473 {

    private static boolean dfs(int target, int pos, int[] nums, Set<Integer> visited) {
        int newTarget = target - nums[pos];
        if (newTarget < 0)
            return false;
        if (newTarget == 0) {
            visited.add(pos);
            return true;
        }

        visited.add(pos);
        for (int i = nums.length - 1; i >= 0; --i) {
            if (visited.contains(i)) {
                continue;
            }
            boolean ans = dfs(newTarget, i, nums, visited);
            if (ans)
                return true;
        }
        visited.remove(pos);

        return false;
    }

    private static boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 4 != 0)
            return false;
        int edgeLen = sum / 4;

        // 优先选择大的元素
        Arrays.sort(nums);
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < 4; ++i) {
            boolean res = false;
            for (int j = nums.length - 1; j >= 0; --j) {
                if (visited.contains(j))
                    continue;
                boolean ans = dfs(edgeLen, j, nums, visited);
                if (ans) {
                    res = true;
                    break;
                }
            }
            if (!res) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2};
        System.out.println(makesquare(nums));

        int[] nums1 = new int[]{3, 3, 3, 3, 4};
        System.out.println(makesquare(nums1));

        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(makesquare(nums2));

    }

}
