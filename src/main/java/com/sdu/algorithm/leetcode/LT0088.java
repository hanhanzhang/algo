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

public class LT0088 {

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针: 从后向前遍历可避免元素移动
        int tail = m + n - 1, i = m - 1, k = n - 1;
        for (; i >= 0 || k >= 0;) {
            if (k < 0)
                break;
            if (i < 0) {
                nums1[tail--] = nums2[k--];
            } else if (nums1[i] >= nums2[k]) {
                nums1[tail--] = nums1[i--];
            } else {
                nums1[tail--] = nums2[k--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0}, nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }

        System.out.println("###############");

        int[] nums3 = new int[]{0, 0, 3, 0, 0, 0, 0, 0, 0};
        int[] nums4 = new int[]{-1, 1, 1, 1, 2, 3};
        merge(nums3, 3, nums4, 6);
        for (int num : nums3) {
            System.out.println(num);
        }
    }

}
