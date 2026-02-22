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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LT140 {

    private static List<String> dfs(String s, int start, Set<String> dict, Map<Integer, List<String>> memo) {
        if (start >= s.length()) {
            return Collections.singletonList("");
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        List<String> ans = new ArrayList<>();
        for (int i = start; i < s.length(); ++i) {
            String word = s.substring(start, i + 1);
            if (dict.contains(word)) {
                List<String> ret = dfs(s, i + 1, dict, memo);
                if (ret == null || ret.isEmpty()) {
                    continue;
                }
                for (String subWords : ret) {
                    ans.add(word + " " + subWords);
                }
            }
        }
        memo.put(start, ans);
        return ans;
    }

    private static List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> dict = new HashSet<>(wordDict);
        // 记忆化搜索(暴力DFS超时)
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, dict, memo);
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak("catsanddog", wordDict));
    }

}
