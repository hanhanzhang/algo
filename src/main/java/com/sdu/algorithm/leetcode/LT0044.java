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

public class LT0044 {

    private static boolean isMatch(String s, String p, int sp, int mp) {
        if (sp == -1 && mp == -1)
            return true;
        if (sp == -1 && mp != -1) {
            for (int i = 0; i <= mp; ++i) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (mp == -1) {
            return false;
        }
        char ch1 = s.charAt(sp), ch2 = p.charAt(mp);
        if (ch1 == ch2 || ch2 == '?') {
            return isMatch(s, p, sp - 1, mp - 1);
        }
        if (ch2 == '*') {
            // 匹配空串或多次
            return isMatch(s, p, sp, mp - 1) || isMatch(s, p, sp - 1, mp);
        }
        return false;
    }

    private static boolean isMatch(String s, String p) {
        // 搜索匹配, 超时
        int sp = (s == null || s.isEmpty()) ? -1 : s.length() - 1;
        int mp = (p == null || p.isEmpty()) ? -1 : p.length() - 1;
        return isMatch(s, p, sp, mp);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "********"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
    }

}
