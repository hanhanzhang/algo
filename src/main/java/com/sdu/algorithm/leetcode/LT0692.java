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

import java.util.*;

public class LT0692 {

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCnt = new HashMap<>();
        for (String word : words) {
            int cnt = wordToCnt.getOrDefault(word, 0);
            wordToCnt.put(word, cnt + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            int cnt1 = wordToCnt.get(o1);
            int cnt2 = wordToCnt.get(o2);
            return cnt1 == cnt2 ? o2.compareTo(o1) : cnt1 - cnt2;
        });
        for (Map.Entry<String, Integer> word : wordToCnt.entrySet()) {
            queue.offer(word.getKey());
            if (queue.size() > k)
                queue.poll();
        }

        LinkedList<String> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.addFirst(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        ListUtils.printList(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        ListUtils.printList(
                topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

}
