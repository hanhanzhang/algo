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

public class LT0152 {

    private static int maxProduct(int[] nums) {
        // dp[i]: 表示以i结尾的最小值和最大值(考虑nums[i]是负数情况)
        int[][] dp = new int[nums.length][];
        dp[0] = new int[]{nums[0], nums[0]};
        int ans = dp[0][1];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = new int[2];
            if (nums[i] < 0) { // 负数
                int min = dp[i - 1][1] * nums[i];
                int max = dp[i - 1][0] * nums[i];
                dp[i][0] = Math.min(min, nums[i]);
                dp[i][1] = Math.max(max, nums[i]);
            } else {
                int min = dp[i - 1][0] * nums[i];
                int max = dp[i - 1][1] * nums[i];
                dp[i][0] = Math.min(min, nums[i]);
                dp[i][1] = Math.max(max, nums[i]);
            }

            if (ans <= dp[i][1]) {
                ans = dp[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{-2, 2, 3, -2}));
        System.out.println(maxProduct(new int[]{-2}));
        System.out.println(maxProduct(new int[]{-2, 1}));
    }

}
