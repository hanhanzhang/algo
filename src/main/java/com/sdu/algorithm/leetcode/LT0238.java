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

public class LT0238 {

    // public int[] productExceptSelf(int[] nums) {
    // // dp[i]: [0, i)区间所有元素乘积
    // // dp[j]: (j, nums.length - 1]区间所有元素乘积
    // int[] dp1 = new int[nums.length];
    // int[] dp2 = new int[nums.length];
    // dp1[0] = 1;
    // dp2[nums.length - 1] = 1;
    // for (int i = 1; i < nums.length; i++) {
    // dp1[i] = dp1[i - 1] * nums[i - 1];
    // }
    // for (int i = nums.length - 2; i >= 0; i--) {
    // dp2[i] = dp2[i + 1] * nums[i + 1];
    // }
    // int[] ans = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    // ans[i] = dp1[i] * dp2[i];
    // }
    // return ans;
    // }

    public int[] productExceptSelf(int[] nums) {
        // 在第一种方法中, 我们可以发现 ans[i] = dp1[i] * dp2[i],
        // 那么我们计算两遍(从左到右, 从右到左)即可满足空间复杂度为o(1)
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp = temp * nums[i + 1];
            ans[i] = ans[i] * temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        LT0238 lt = new LT0238();
        ArrayUtils.printArray(lt.productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
