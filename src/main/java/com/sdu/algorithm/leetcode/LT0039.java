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

public class LT0039 {

    // start位置用于去重, 表示start前的元素不可再次被选择
    private static List<List<Integer>> combinationSum(int[] candidates, int start, int target) {
        if (target < 0) {
            return null;
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int i = start; i < candidates.length; ++i) {
            int newTarget = target - candidates[i];
            if (newTarget == 0) {
                List<Integer> sub = new LinkedList<>();
                sub.add(candidates[i]);
                result.add(sub);
            } else {
                // 当前节点可用多次, 故从i处开始搜索, i之前的元素表示不可再选择
                List<List<Integer>> subResult = combinationSum(candidates, i, newTarget);
                if (subResult == null) {
                    continue;
                }
                for (List<Integer> sub : subResult) {
                    sub.add(candidates[i]);
                    result.add(sub);
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return Collections.emptyList();
        }
        return combinationSum(candidates, 0, target);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{7, 3, 6, 2}, 7);
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

}
