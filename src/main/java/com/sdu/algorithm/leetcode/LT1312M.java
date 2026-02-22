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

public class LT1312M {

    private static int minInsertions(String s) {
        // 区间动态规划, 参考: https://blog.csdn.net/u012679087/article/details/84109739
        // dp[i][j]: (i, j)变为回文串的最小次数
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; ++len) {
            for (int l = 0; l + len - 1 < n; ++l) { // 保证(l, r)区间长度为len且不越界
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = dp[l + 1][r - 1];
                } else {
                    dp[l][r] = Math.min(dp[l + 1][r] + 1, dp[l][r - 1] + 1);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
    }

}
