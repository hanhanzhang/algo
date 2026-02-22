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
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LT332 {

    private static void findItinerary(String start, Map<String, List<String>> graph, List<String> ans) {
        List<String> nbr = graph.get(start);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.remove(0);
            findItinerary(dest, graph, ans);
        }
        // 逆序插入
        ans.add(0, start);
    }

    private static List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> arrived = graph.computeIfAbsent(ticket.get(0), key -> new LinkedList<>());
            arrived.add(ticket.get(1));
        }

        for (Entry<String, List<String>> e : graph.entrySet()) {
            Collections.sort(e.getValue());
        }

        List<String> ans = new LinkedList<>();
        findItinerary("JFK", graph, ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new LinkedList<>();
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));

        System.out.println(findItinerary(tickets));

        List<List<String>> tickets1 = new LinkedList<>();
        tickets1.add(Arrays.asList("JFK", "ATL"));
        tickets1.add(Arrays.asList("ATL", "JFK"));
        System.out.println(findItinerary(tickets1));

        List<List<String>> tickets2 = new LinkedList<>();
        tickets2.add(Arrays.asList("JFK", "AAA"));
        tickets2.add(Arrays.asList("AAA", "JFK"));
        tickets2.add(Arrays.asList("JFK", "BBB"));
        tickets2.add(Arrays.asList("JFK", "CCC"));
        tickets2.add(Arrays.asList("CCC", "JFK"));
        System.out.println(findItinerary(tickets2));

        List<List<String>> tickets3 = new LinkedList<>();
        tickets3.add(Arrays.asList("JFK", "SFO"));
        tickets3.add(Arrays.asList("JFK", "ATL"));
        tickets3.add(Arrays.asList("SFO", "ATL"));
        tickets3.add(Arrays.asList("ATL", "JFK"));
        tickets3.add(Arrays.asList("ATL", "SFO"));
        System.out.println(findItinerary(tickets3));

        // 重复边
        List<List<String>> tickets4 = new LinkedList<>();
        tickets4.add(Arrays.asList("EZE", "AXA"));
        tickets4.add(Arrays.asList("TIA", "ANU"));
        tickets4.add(Arrays.asList("ANU", "JFK"));
        tickets4.add(Arrays.asList("JFK", "ANU"));
        tickets4.add(Arrays.asList("ANU", "EZE"));
        tickets4.add(Arrays.asList("TIA", "ANU"));
        tickets4.add(Arrays.asList("AXA", "TIA"));
        tickets4.add(Arrays.asList("TIA", "JFK"));
        tickets4.add(Arrays.asList("ANU", "TIA"));
        tickets4.add(Arrays.asList("JFK", "TIA"));
        System.out.println(findItinerary(tickets4));

    }

}
