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

import com.sdu.algorithm.utils.TreeUtils;
import com.sdu.algorithm.utils.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT508 {

    private static int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> res) {
        if (root == null)
            return 0;
        int cur = findFrequentTreeSum(root.left, res) + findFrequentTreeSum(root.right, res) + root.val;
        Integer cnt = res.getOrDefault(cur, 0);
        res.put(cur, cnt + 1);
        return cur;
    }

    private static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> res = new HashMap<>();
        findFrequentTreeSum(root, res);
        List<Integer> maxSum = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            int cur = entry.getValue();
            if (cur > max) {
                maxSum.clear();
                max = cur;
                maxSum.add(entry.getKey());
            } else if (cur == max) {
                maxSum.add(entry.getKey());
            }
        }
        int[] ans = new int[maxSum.size()];
        for (int i = 0; i < maxSum.size(); ++i) {
            ans[i] = maxSum.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{5, 2, -5});
        int[] ans = findFrequentTreeSum(root);
        for (int sum : ans) {
            System.out.println(sum);
        }
    }

}
