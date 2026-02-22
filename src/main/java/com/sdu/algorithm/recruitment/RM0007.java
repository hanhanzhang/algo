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

package com.sdu.algorithm.recruitment;

import java.util.ArrayList;
import java.util.List;

public class RM0007 {

    private static List<List<Integer>> composeInternal(int[] array, int selected, int k, int start) {
        // 结束条件
        if (selected == k) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start; i < array.length; ++i) {
            // 选择其他元素
            List<List<Integer>> ret = composeInternal(array, selected + 1, k, i + 1);
            if (ret == null) {
                List<Integer> sub = new ArrayList<>();
                sub.add(array[i]);
                ans.add(sub);
            } else {
                for (List<Integer> child : ret) {
                    child.add(array[i]);
                    ans.add(child);
                }
            }
        }
        return ans;
    }

    private static List<List<Integer>> compose(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return null;
        }
        int[] array = new int[n];
        for (int i = 1; i <= n; ++i) {
            array[i - 1] = i;
        }

        return composeInternal(array, 0, k, 0);
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = compose(4, 2);
        for (List<Integer> ret : ans) {
            System.out.println(ret);
        }

        System.out.println("***********");

        List<List<Integer>> ans1 = compose(5, 3);
        for (List<Integer> ret : ans1) {
            System.out.println(ret);
        }

        System.out.println("***********");

        List<List<Integer>> ans2 = compose(5, 5);
        for (List<Integer> ret : ans2) {
            System.out.println(ret);
        }
    }

}
