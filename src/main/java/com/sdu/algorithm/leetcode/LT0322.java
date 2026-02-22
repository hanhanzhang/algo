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

public class LT0322 {

    private static int dfs(int[] coins, int amount, Integer[] memo) {
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != null) {
            return memo[amount];
        }

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }
            int ret = dfs(coins, amount - coin, memo);
            if (ret == -1) {
                continue;
            }
            result = Math.min(result, ret + 1);
        }

        result = result == Integer.MAX_VALUE ? -1 : result;
        memo[amount] = result;

        return memo[amount];
    }

    private static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        // dfs + 记忆化搜索
        Integer[] memo = new Integer[amount + 1];
        memo[0] = 0;
        return dfs(coins, amount, memo);
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 1));
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1, 2, 5}, 100));
    }

}
