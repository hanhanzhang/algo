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

public class LT0011 {

    private static int maxArea(int[] height) {
        /*
         * 双指针
         *
         * Area = Math.min(height[l], height[h]) * (h - l)
         */
        int l = 0, h = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (l < h) {
            int area = Math.min(height[l], height[h]) * (h - l);
            if (area > ans) {
                ans = area;
            }
            if (height[l] < height[h]) {
                ++l;
            } else {
                --h;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
