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

public class LT0134 {

    private static boolean dfs(int start, int next, int remain, int[] gas, int[] cost) {
        int pos = next % gas.length;
        // 判断是否可到达下个加油站
        int cur = (next - 1) % gas.length;
        if (remain < cost[cur])
            return false;
        // 回到原点
        if (start == pos)
            return true;
        return dfs(start, next + 1, remain + gas[pos] - cost[cur], gas, cost);
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; ++i) {
            boolean res = dfs(i, i + 1, gas[i], gas, cost);
            if (res)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

}
