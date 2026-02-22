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

import com.sdu.algorithm.utils.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT0015 {

    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                break;
            // 去除重复
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    right -= 1;
                    // 重复元素
                    while (left < right && nums[left] == nums[left - 1])
                        left += 1;
                    while (left < right && nums[right] == nums[right + 1])
                        right -= 1;
                } else if (nums[left] + nums[right] > target) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        ListUtils.printList(res);
    }

}
