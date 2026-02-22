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

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LT0264 {

    private static int nthUglyNumber(int n) {
        int[] factors = new int[]{2, 3, 5};
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        visited.add(1L);
        queue.offer(1L);
        int ugly = 0;
        for (int i = 1; i <= n; ++i) {
            long cur = queue.poll();
            ugly = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(4));
        System.out.println(nthUglyNumber(10));
    }

}
