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

public class LT0228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j - 1] + 1 == nums[j]) {
                j += 1;
            } else if (i == j - 1) {
                ans.add(nums[i] + "");
                i = j;
                j += 1;
            } else {
                ans.add(nums[i] + "->" + nums[j - 1]);
                i = j;
                j += 1;
            }
        }

        if (i != j - 1) {
            ans.add(nums[i] + "->" + nums[j - 1]);
        } else {
            ans.add(nums[i] + "");
        }

        return ans;
    }

    public static void main(String[] args) {
        LT0228 lt = new LT0228();
        System.out.println(lt.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(lt.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
