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

public class LT0209 {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = nums[i];
        while (j < nums.length) {
            if (sum < target) {
                if (j == nums.length - 1) {
                    break;
                }
                j += 1;
                sum += nums[j];
            } else {
                do {
                    minLen = Math.min(minLen, j - i + 1);
                    sum -= nums[i];
                    i += 1;
                } while (sum >= target);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        LT0209 lt0209 = new LT0209();
        System.out.println(lt0209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(lt0209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

}
