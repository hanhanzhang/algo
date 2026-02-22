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

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0912 {

    private static void quickSort(int[] nums, int st, int et) {
        if (st < 0 || st >= nums.length || st >= et)
            return;
        int target = nums[st];
        int low = st, high = et;
        while (low < high) {
            // 找第一个大于target的元素
            while (low < high && nums[low] <= target) {
                low += 1;
            }
            // 找第一个小于target的元素
            while (high > low && nums[high] >= target) {
                high -= 1;
            }
            if (low != high) {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
            }
        }
        if (target >= nums[low]) {
            // 移动元素
            for (int i = st + 1; i <= low; ++i) {
                nums[i - 1] = nums[i];
            }
            nums[low] = target;
            quickSort(nums, st, low - 1);
            quickSort(nums, low + 1, et);
        } else {
            // 移动元素
            for (int i = st + 1; i < low; ++i) {
                nums[i - 1] = nums[i];
            }
            nums[low - 1] = target;
            quickSort(nums, st, low - 2);
            quickSort(nums, low, et);
        }
    }

    // 快排
    private static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        ArrayUtils.printArray(sortArray(new int[]{5, 2, 3, 1}));
        ArrayUtils.printArray(sortArray(new int[]{5, 1, 1, 2, 0, 0}));
        ArrayUtils.printArray(sortArray(new int[]{1, 0, 0, 2, 0}));
    }

}
