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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LT0078 {

    private static List<List<Integer>> dfs(int[] nums, int start) {
        List<List<Integer>> ans = new LinkedList<>();
        if (start >= nums.length) {
            ans.add(new LinkedList<>());
            return ans;
        }

        List<List<Integer>> sub = dfs(nums, start + 1);
        ans.addAll(sub);
        for (List<Integer> s : sub) {
            List<Integer> ss = new LinkedList<>();
            ss.add(nums[start]);
            ss.addAll(s);
            ans.add(ss);
        }

        return ans;
    }

    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        return dfs(nums, 0);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}
