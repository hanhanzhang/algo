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

package com.sdu.algorithm.offercode;

import java.util.PriorityQueue;
import java.util.Queue;

public class OR045 {

    private static String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            String n1 = o1 + o2;
            String n2 = o2 + o1;
            return n1.compareTo(n2);
        });
        for (int num : nums)
            queue.offer("" + num);
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
        System.out.println(minNumber(new int[]{3, 30, 34, 5, 9}));
    }

}
