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

import java.util.Stack;

public class LT0151 {

    private static String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return "";

        Stack<String> stack = new Stack<>();

        int start = 0;
        while (start < s.length()) {
            while (start < s.length() && s.charAt(start) == ' ')
                ++start;
            int end = start;
            while (end < s.length() && s.charAt(end) != ' ')
                ++end;
            if (start < s.length()) {
                stack.push(s.substring(start, end));
                start = end;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while (!stack.isEmpty()) {
            if (first) {
                sb.append(stack.pop());
                first = false;
            } else {
                sb.append(" ");
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }

}
