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

public class LT0300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i]: 以i为起点的最长递增子序列长度
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int res = dp[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            int num = nums[i];
            int maxLen = 1;
            for (int k = i + 1; k < nums.length; ++k) {
                if (num < nums[k] && maxLen < dp[k] + 1) {
                    maxLen = dp[k] + 1;
                }
            }
            dp[i] = maxLen;
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(lengthOfLIS(new int[]{0}));
    }

}
