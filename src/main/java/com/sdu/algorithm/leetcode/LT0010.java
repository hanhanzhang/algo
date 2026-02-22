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

public class LT0010 {

    private static boolean dfs(String s, String p, int sp, int pp) {
        // '.': 匹配任意一个单字符
        // '*': 匹配零个或多个前面的那一个元素
        if (sp == s.length() && pp == p.length()) {
            return true;
        }
        if (sp != s.length() && pp == p.length()) {
            // pattern先到达尾部, 匹配失败
            return false;
        }
        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            if ((sp != s.length() && s.charAt(sp) == p.charAt(pp))
                    || (sp != s.length() && p.charAt(pp) == '.')) {
                return dfs(s, p, sp + 1, pp)
                        || dfs(s, p, sp + 1, pp + 2)
                        || dfs(s, p, sp, pp + 2);
            } else {
                return dfs(s, p, sp, pp + 2);
            }
        }
        if (sp != s.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.')) {
            return dfs(s, p, sp + 1, pp + 1);
        }

        return false;
    }

    private static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return dfs(s, p, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("a", "ab*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

}
