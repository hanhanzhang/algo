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

public class LT0611 {

    private static boolean isValidTriangle(int[] edges) {
        return edges[0] + edges[1] > edges[2]
                && edges[0] + edges[2] > edges[1]
                && edges[1] + edges[2] > edges[0];
    }

    private static int triangleSets(int[] nums, int start, int[] edges, int pos) {
        if (pos == 3) {
            return isValidTriangle(edges) ? 1 : 0;
        }
        if (start >= nums.length)
            return 0;
        int ans = 0;
        for (int i = start; i < nums.length; ++i) {
            if (pos == 0)
                edges = new int[3];
            edges[pos] = nums[i];
            int[] ret = new int[3];
            System.arraycopy(edges, 0, ret, 0, pos + 1);
            ans += triangleSets(nums, i + 1, ret, pos + 1);
        }
        return ans;
    }

    private static int triangleNumber(int[] nums) {
        // 计算超时
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 3个元素所有组合
        return triangleSets(nums, 0, nums, 0);
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(triangleNumber(new int[]{2, 1, 1}));
    }

}
