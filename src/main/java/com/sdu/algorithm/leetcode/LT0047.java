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
import java.util.Collections;
import java.util.List;

public class LT0047 {

    private static List<List<Integer>> backtrack(int[] nums, boolean[] visited) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            // 剪枝条件: nums[i] == nums[i - 1] & visited[i - 1] == false
            // 关键点: 相同元素已选择
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            List<List<Integer>> subPermutes = backtrack(nums, visited);
            if (subPermutes.isEmpty()) {
                List<Integer> ret = new ArrayList<>();
                ret.add(nums[i]);
                ans.add(ret);
            } else {
                for (List<Integer> ret : subPermutes) {
                    ret.add(nums[i]);
                    ans.add(ret);
                }
            }
            visited[i] = false;
        }
        return ans;
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        return backtrack(nums, new boolean[nums.length]);
    }

    public static void main(String[] args) {
        List<List<Integer>> permutes = permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> permute : permutes) {
            System.out.println(permute);
        }
    }

}
