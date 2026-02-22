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

import com.sdu.algorithm.utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LT0239 {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] res = new int[nums.length - k + 1];
        int cur = 0;
        for (int i = 0; i < res.length; ++i) {
            int index = -1;
            while (cur < nums.length) {
                queue.offer(new int[]{cur, nums[cur]});
                int leftIndex = cur - k + 1;
                cur += 1;
                if (leftIndex >= 0) {
                    int[] top = queue.peek();
                    assert top != null;
                    if (top[0] < leftIndex) {
                        while (top != null && top[0] < leftIndex) {
                            queue.poll();
                            top = queue.peek();
                        }
                    }
                    assert top != null;
                    index = top[0];
                    break;
                }
            }
            if (index != -1)
                res[i] = nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res1 = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        ArrayUtils.printArray(res1);

        int[] res2 = maxSlidingWindow(new int[]{9, 11}, 2);
        ArrayUtils.printArray(res2);
    }

}
