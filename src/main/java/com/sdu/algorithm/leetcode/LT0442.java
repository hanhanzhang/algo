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

import com.sdu.algorithm.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class LT0442 {

    private static List<Integer> findDuplicates(int[] nums) {
        // 负数标记出现过, 无需移动元素
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                res.add(num);
            } else {
                nums[num - 1] *= -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListUtils.printList(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
