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

import java.util.LinkedList;
import java.util.List;

public class LT0022 {

    /**
     * @param ret   中间结果
     * @param left  剩余左括号数量
     * @param right 剩余右括号数量
     * @param ans   有效括号结果集
     * */
    private static void dfs(String ret, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(ret);
            return;
        }
        if (left > right) {
            // 剪枝(左括号剩余量多余右括号, 则说明不是有效的括号)
            return;
        }
        if (left > 0) {
            dfs(ret + "(", left - 1, right, ans);
        }

        if (right > 0) {
            dfs(ret + ")", left, right - 1, ans);
        }
    }

    private static List<String> generateParenthesis(int n) {
        // 类似组合
        List<String> ans = new LinkedList<>();
        dfs("", n, n, ans);
        return ans;
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for (String pattern : result) {
            System.out.println(pattern);
        }

        System.out.println("********");

        List<String> result1 = generateParenthesis(0);
        for (String pattern : result1) {
            System.out.println(pattern);
        }
    }

}
