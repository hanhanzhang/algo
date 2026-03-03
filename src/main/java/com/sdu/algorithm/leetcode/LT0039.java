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

public class LT0039 {

    // start位置用于去重, 表示start前的元素不可再次被选择
//    private static List<List<Integer>> combinationSum(int[] candidates, int start, int target) {
//        if (target < 0) {
//            return null;
//        }
//
//        List<List<Integer>> result = new LinkedList<>();
//        for (int i = start; i < candidates.length; ++i) {
//            int newTarget = target - candidates[i];
//            if (newTarget == 0) {
//                List<Integer> sub = new LinkedList<>();
//                sub.add(candidates[i]);
//                result.add(sub);
//            } else {
//                // 当前节点可用多次, 故从i处开始搜索, i之前的元素表示不可再选择
//                List<List<Integer>> subResult = combinationSum(candidates, i, newTarget);
//                if (subResult == null) {
//                    continue;
//                }
//                for (List<Integer> sub : subResult) {
//                    sub.add(candidates[i]);
//                    result.add(sub);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (candidates == null || candidates.length == 0 || target < 0) {
//            return Collections.emptyList();
//        }
//        return combinationSum(candidates, 0, target);
//    }

    private void dfs(int[] candidates, int offset, int target, List<List<Integer>> res, List<Integer> ret) {
        if (offset >= candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(ret));
            return;
        }
        for (int i = offset; i < candidates.length; i++) {
            ret.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], res, ret);
            ret.remove(ret.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        LT0039 lt = new LT0039();
        List<List<Integer>> result = lt.combinationSum(new int[]{2,3,5}, 8);
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

}
