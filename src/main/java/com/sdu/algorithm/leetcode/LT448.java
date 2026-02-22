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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LT448 {

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i += 1;
                continue;
            }

            if (nums[nums[i] - 1] != 0) {
                // 两种情况: 重复或交换
                if (nums[nums[i] - 1] == nums[i]) {
                    nums[i] = 0;
                    i += 1;
                } else {
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                }
            } else {
                nums[nums[i] - 1] = nums[i];
                nums[i] = 0;
                i += 1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] == 0 || nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    private static List<Integer> findDisappearedNumbers1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        // 标记, 出现过标记为负数
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] = -1 * nums[num - 1];
            }
        }

        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        // System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbers1(nums));

        int[] nums1 = new int[]{39, 31, 8, 14, 14, 38, 5, 15, 29, 49, 18, 6, 30, 47, 8, 35, 2, 17, 6, 10, 29, 46, 41,
                48, 1, 36, 5, 28, 46, 39, 7, 47, 18, 42, 17, 11, 36, 45, 21, 33, 24, 10, 24, 50, 25, 16, 9, 12, 11, 25};
        // System.out.println(findDisappearedNumbers(nums1));
        System.out.println(findDisappearedNumbers1(nums1));
    }

}
