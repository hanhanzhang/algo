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

import java.util.ArrayList;
import java.util.List;

public class LT1755 {

    public static int minAbsDifference(int[] nums, int goal) {
        // dpSums[i]: 表示以i结尾所有子序列的和
        List<Integer>[] dpSums = new List[nums.length];
        int nearSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            dpSums[i] = new ArrayList<>();
            dpSums[i].add(nums[i]);
            if (i - 1 >= 0) {
                for (int sum : dpSums[i - 1]) {
                    dpSums[i].add(sum);
                    dpSums[i].add(sum + nums[i]);
                }
            }

            for (int sum : dpSums[i]) {
                if (Math.abs(sum - goal) <= Math.abs(nearSum - goal)) {
                    nearSum = sum;
                }
            }
        }

        return Math.abs(nearSum - goal);
    }

    public static void main(String[] args) {
        System.out.println(minAbsDifference(new int[]{5, -7, 3, 5}, 6));
        System.out.println(minAbsDifference(new int[]{7, -9, 15, -2}, -5));
        System.out.println(minAbsDifference(new int[]{1, 2, 3}, -7));
    }

}
