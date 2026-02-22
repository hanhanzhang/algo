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
import java.util.LinkedList;
import java.util.List;

public class LT0040 {

    private static void find(int[] candidates, int target, int start, List<Integer> mid, List<List<Integer>> result) {
        if (target == 0) {
            result.add(mid);
            return;
        }
        if (target < 0) {
            return;
        }
        boolean first = true;
        for (int i = start; i < candidates.length; ++i) {
            if (first || candidates[i - 1] != candidates[i]) { // 去重
                List<Integer> newMid = new LinkedList<>(mid);
                newMid.add(candidates[i]);
                find(candidates, target - candidates[i], i + 1, newMid, result);
            }
            first = false;
        }
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

}
