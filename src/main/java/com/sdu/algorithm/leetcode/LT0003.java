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

import java.util.HashSet;
import java.util.Set;

public class LT0003 {

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        // 双指针
        Set<Character> windowElements = new HashSet<>();
        int max = 1, start = 0;
        windowElements.add(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (windowElements.contains(ch)) {
                // 移除元素
                int j = start;
                for (; s.charAt(j) != ch; ++j) {
                    windowElements.remove(s.charAt(j));
                }
                start = j + 1;
            } else {
                windowElements.add(ch);
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

}
