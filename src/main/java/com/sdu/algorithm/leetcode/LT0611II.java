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

public class LT0611II {

    private static int triangleNumber(int[] nums) {
        // 数组排序, a <= b <= c, 故 a + c > b 和 b + c > a 一定成立, 只需判断 a + b >= c 且 a 或 b 不可为 0
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; ++j) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                ans += k - j - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(triangleNumber(new int[]{2, 1, 1}));
    }

}
