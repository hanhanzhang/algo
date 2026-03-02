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
import java.util.List;

public class LT0078 {

//    private static List<List<Integer>> dfs(int[] nums, int start) {
//        List<List<Integer>> ans = new LinkedList<>();
//        if (start >= nums.length) {
//            ans.add(new LinkedList<>());
//            return ans;
//        }
//
//        List<List<Integer>> sub = dfs(nums, start + 1);
//        ans.addAll(sub);
//        for (List<Integer> s : sub) {
//            List<Integer> ss = new LinkedList<>();
//            ss.add(nums[start]);
//            ss.addAll(s);
//            ans.add(ss);
//        }
//
//        return ans;
//    }
//
//    private static List<List<Integer>> subsets(int[] nums) {
//        if (nums == null) {
//            return Collections.emptyList();
//        }
//        return dfs(nums, 0);
//    }

    private void subsets(int[] nums, int offset, int cnt, int selected, List<List<Integer>> res, List<Integer> ret) {
        if (selected == cnt) {
            res.add(new ArrayList<>(ret));
            return;
        }
        for (int i = offset; i < nums.length; i++) {
            ret.add(nums[i]);
            subsets(nums, i + 1, cnt, selected + 1, res, ret);
            ret.remove(ret.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            subsets(nums, 0, i, 0, res, new ArrayList<>());
        }
        return res;
    }


    public static void main(String[] args) {
        LT0078 lt = new LT0078();
        System.out.println(lt.subsets(new int[]{1, 2, 3}));
    }

}
