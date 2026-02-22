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

package com.sdu.algorithm.offercode;

public class OR053II {

    // 在排序数组中查找数字出现次数
    private static int search(int[] nums, int target) {
        // TODO: 折半查找
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        if (nums[low] > target || nums[high] < target) {
            return 0;
        }
        while (low <= high && (nums[low] != target || nums[high] != target)) {
            if (nums[low] < target) {
                low += 1;
            }
            if (nums[high] > target) {
                high -= 1;
            }
        }
        return low > high ? 0 : high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

}
