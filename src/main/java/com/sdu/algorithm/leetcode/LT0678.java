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

public class LT0678 {

    // DFS提交超时
    private static boolean dfs(String s, int start, int cnt) {
        if (cnt < 0)
            return false;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt += 1;
            } else if (c == ')') {
                cnt -= 1;
                if (cnt < 0)
                    return false;
            } else if (c == '*') {
                return dfs(s, i + 1, cnt + 1) ||
                        dfs(s, i + 1, cnt - 1) ||
                        dfs(s, i + 1, cnt);
            }
        }
        return cnt == 0;
    }

    private static boolean checkValidString(String s) {
        return dfs(s, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*)))"));
        System.out.println(checkValidString(
                "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        // System.out.println(checkValidString("************************************************************"));
    }

}
