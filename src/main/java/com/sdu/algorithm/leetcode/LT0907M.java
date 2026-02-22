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

import java.util.Stack;

public class LT0907M {

    private static int sumSubarrayMins(int[] arr) {
        // https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/dan-diao-zhan-zuo-you-liang-bian-di-yi-g-ww3n/
        // 暴力解法, 提交超时
        int MOD = 1_000_000_007;
        Stack<int[]> stack = new Stack<>();
        int ans = 0, dot = 0;
        for (int i = 0; i < arr.length; ++i) {
            int count = 1;
            //
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                // 更新最小值
                int[] mir = stack.pop();
                count += mir[1];
                dot -= mir[0] * mir[1];
            }
            stack.push(new int[]{arr[i], count});
            dot += arr[i] * count;
            ans += dot;
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
    }

}
