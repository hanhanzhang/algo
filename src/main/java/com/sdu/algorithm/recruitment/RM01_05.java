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

package com.sdu.algorithm.recruitment;

public class RM01_05 {

    private static boolean oneEditAway(String first, String second) {
        // dp[i][j]: 字符串(0, i) 转为字符串(0, j)的最小变化次数
        // dp[i][j] = dp[i - 1][j - 1], 若 s(i) = s(j)
        // 插入 删除 替换
        // dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1, 若 s(i) != s(j)
        int n = first.length(), m = second.length();
        int[][] dp = new int[n + 1][m + 1];

        // 初始化
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m] <= 1;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pal"));
    }

}
