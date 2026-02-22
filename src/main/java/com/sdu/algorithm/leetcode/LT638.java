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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT638 {

    private static int dfs(List<List<Integer>> special, List<Integer> needs) {
        /*
         * 深度搜索结束条件: 购物清单清零
         */
        if (needs.stream().allMatch(num -> num == 0)) {
            return 0;
        }

        // TODO: 剪枝
        int min = Integer.MAX_VALUE;
        for (List<Integer> s : special) {
            List<Integer> copyNeeds = new ArrayList<>(needs);
            int cost = s.get(s.size() - 1);
            for (int i = 0; i < s.size() - 1; ++i) {
                copyNeeds.set(i, copyNeeds.get(i) - s.get(i));
            }
            boolean selectable = false;
            for (int i = 0; i < needs.size(); ++i) {
                if (copyNeeds.get(i) < 0) {
                    selectable = false;
                    break;
                }
                if (copyNeeds.get(i) < needs.get(i)) {
                    selectable = true;
                }
            }
            if (selectable) {
                cost += dfs(special, copyNeeds);
                if (min > cost) {
                    min = cost;
                }
            }
        }
        return min;
    }

    private static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int kind = price.size();
        for (int i = 0; i < kind; ++i) {
            List<Integer> s = new ArrayList<>(kind + 1);
            for (int k = 0; k < kind; ++k) {
                s.add(k == i ? 1 : 0);
            }
            s.add(price.get(i));
            special.add(s);
        }

        return dfs(special, needs);
    }

    public static void main(String[] args) {
        List<Integer> price1 = Arrays.asList(2, 5);
        List<List<Integer>> special1 = new ArrayList<>();
        special1.add(Arrays.asList(3, 0, 5));
        special1.add(Arrays.asList(1, 2, 10));
        List<Integer> needs1 = Arrays.asList(3, 2);
        System.out.println(shoppingOffers(price1, special1, needs1));

        List<Integer> price2 = Arrays.asList(2, 3, 4);
        List<List<Integer>> special2 = new ArrayList<>();
        special2.add(Arrays.asList(1, 1, 0, 4));
        special2.add(Arrays.asList(2, 2, 1, 9));
        List<Integer> needs2 = Arrays.asList(1, 2, 1);
        System.out.println(shoppingOffers(price2, special2, needs2));
    }

}
