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

public class LT0005 {

    private static String longestPalindrome(String s) {
        // 区间动态规划
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int pos = 0, maxLen = 1;
        for (int i = 0; i < n; ++i)
            dp[i][i] = true;
        for (int len = 2; len <= n; ++len) {
            for (int l = 0; l + len - 1 < n; ++l) {
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = r - l < 3 || dp[l + 1][r - 1];
                } else {
                    dp[l][r] = false;
                }
                if (dp[l][r] && (r - l + 1) > maxLen) {
                    pos = l;
                    maxLen = r - l + 1;
                }
            }
        }
        return s.substring(pos, pos + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("ac"));
    }

}
