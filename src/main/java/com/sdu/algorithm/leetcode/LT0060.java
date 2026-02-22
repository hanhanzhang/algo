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

public class LT0060 {

    private static String ans = null;
    private static int cnt = 0;

    private static void permutation(int n, boolean[] visited, StringBuilder nums, int k) {
        if (nums.length() == n) {
            if (++cnt == k) {
                ans = nums.toString();
            }
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (visited[i - 1])
                continue;
            StringBuilder ret = new StringBuilder(nums);
            ret.append(i);
            visited[i - 1] = true;
            permutation(n, visited, ret, k);
            visited[i - 1] = false;
            if (ans != null)
                break;
        }
    }

    private static String getPermutation(int n, int k) {
        permutation(n, new boolean[n], new StringBuilder(), k);
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
    }

}
