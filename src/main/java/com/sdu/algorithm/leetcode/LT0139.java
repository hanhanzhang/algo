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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LT0139 {

    private static boolean dfs(String s, int start, Set<String> dict) {
        if (start >= s.length()) {
            return true;
        }

        // 递归+回溯, 若不使用记忆化搜索, 超出时间限制
        for (int end = start + 1; end <= s.length(); ++end) {
            String word = s.substring(start, end);
            if (dict.contains(word) && dfs(s, end, dict)) {
                return true;
            }
        }
        return false;
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return false;

        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, 0, dict);
    }

    // --------------- 记忆化搜索 ---------------
    private static boolean dfs1(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start >= s.length()) {
            return true;
        }
        if (memo[start] != null) { // 已被搜索
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); ++end) {
            String word = s.substring(start, end);
            if (dict.contains(word) && dfs1(s, end, dict, memo)) {
                memo[start] = true;
                return true;
            }
            memo[start] = false;
        }
        return false;
    }

    private static boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return false;

        Set<String> dict = new HashSet<>(wordDict);
        return dfs1(s, 0, dict, new Boolean[s.length()]);
    }

    public static void main(String[] args) {
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak("leetcode", wordDict1));
        System.out.println(wordBreak1("leetcode", wordDict1));

        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(wordBreak("applepenapple", wordDict2));
        System.out.println(wordBreak1("applepenapple", wordDict2));

        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak("catsandog", wordDict3));
        System.out.println(wordBreak1("catsandog", wordDict3));
    }

}
