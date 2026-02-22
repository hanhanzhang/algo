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

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.sdu.algorithm.utils.ArrayUtils.printArray;

public class OR040 {

    private static int[] getLeastNumbers(int[] arr, int k) {

        class IntComparator implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new IntComparator());
        for (int i = 0; i < arr.length; ++i) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else {
                queue.add(arr[i]);
                queue.poll();
            }
        }
        return queue.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        printArray(getLeastNumbers(new int[]{3, 2, 1}, 2));
        printArray(getLeastNumbers(new int[]{0, 1, 2, 1}, 1));
    }

}
