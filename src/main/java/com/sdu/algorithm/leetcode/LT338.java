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

public class LT338 {

    private static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; ++i) {
            int cnt = 0;
            int tmp = i;
            while (tmp != 0) {
                cnt += (tmp & 1) == 0 ? 0 : 1;
                tmp = tmp >> 1;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    private static int[] countBits1(int num) {
        // TODO: 动态规划
        return null;
    }

    public static void main(String[] args) {
        // 2 -> [0, 1, 1]
        int[] ans = countBits(2);
        for (int a : ans) {
            System.out.println(a);
        }
        System.out.println("******");
        // 5 -> [0, 1, 1, 2, 1, 2]
        int[] ans1 = countBits(5);
        for (int a : ans1) {
            System.out.println(a);
        }
    }

}
