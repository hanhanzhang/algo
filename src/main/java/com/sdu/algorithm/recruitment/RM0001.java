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

public class RM0001 {

    private static List<List<Integer>> permutation(int[] array, int i, int[] visited) {
        if (i == array.length) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < array.length; ++k) {
            if (visited[k] == 1) {
                continue;
            }
            visited[k] = 1;
            List<List<Integer>> ret = permutation(array, i + 1, visited);
            if (ret == null) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(array[k]);
                ans.add(res);
            } else {
                for (List<Integer> sub : ret) {
                    sub.add(0, array[k]);
                    ans.add(sub);
                }
            }
            visited[k] = 0;
        }

        return ans;
    }

    private static List<List<Integer>> permutation(int[] array) {
        assert array != null && array.length != 0;
        return permutation(array, 0, new int[array.length]);
    }

    public static void main(String[] args) {
        System.out.println(permutation(new int[]{1, 2, 3}));
    }

}
