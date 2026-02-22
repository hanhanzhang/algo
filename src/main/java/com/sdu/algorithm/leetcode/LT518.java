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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LT518 {

    private static int dfs(int amount, int[] coins, int start, Map<String, Integer> memo) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 1;
        }
        if (memo.containsKey(amount + "#" + start)) {
            return memo.get(amount + "#" + start);
        }
        int ans = 0;
        for (int i = start; i < coins.length; ++i) {
            int newAmount = amount - coins[i];
            // 剪枝
            if (newAmount < 0) {
                break;
            }
            int ret = dfs(newAmount, coins, i, memo);
            if (ret > 0) {
                ans += ret;
            }
        }
        memo.put(amount + "#" + start, ans);
        return ans;
    }

    private static int change(int amount, int[] coins) {
        if (amount < 0) {
            return 0;
        }
        Arrays.sort(coins);
        return dfs(amount, coins, 0, new HashMap<>());
    }

    private static int change01(int amount, int[] coins) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; ++j) {
                if (j >= coin) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
        System.out.println(change(2, new int[]{3}));
        System.out.println(change(100, new int[]{99, 1}));
        System.out.println(change(500, new int[]{3, 5, 7, 8, 9, 10, 11}));

        System.out.println(change01(500, new int[]{3, 5, 7, 8, 9, 10, 11}));
    }

}
