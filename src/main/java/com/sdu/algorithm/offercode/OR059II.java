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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class OR059II {

    public static class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            maxQueue = new ArrayDeque<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            // maxQueue移除比当前value小的元素
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
                return -1;
            int value = queue.poll();
            if (value == maxQueue.peekFirst())
                maxQueue.pollFirst();
            return value;
        }
    }

    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(3);
        queue.push_back(2);
        queue.push_back(1);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }

}
