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

import java.util.Deque;
import java.util.LinkedList;

public class LT0071 {

    private static void simplifyPath(Deque<String> deque, String dir) {
        switch (dir) {
            case ".":
                break;
            case "..":
                if (!deque.peek().equals("/")) {
                    deque.pop();
                }
                break;
            default:
                deque.push(dir);
                break;
        }
    }

    private static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        deque.push("/");

        int start = 0;
        int end = 0;
        while (end < path.length()) {
            if (path.charAt(start) == '/') {
                start += 1;
            }
            if (path.charAt(end) == '/' && end > start) {
                String dir = path.substring(start, end);
                simplifyPath(deque, dir);
                start = end + 1;
            }
            end += 1;
        }

        if (end > start) {
            String dir = path.substring(start, end);
            simplifyPath(deque, dir);
        }

        StringBuilder sb = new StringBuilder();
        int size = deque.size();
        int index = 0;
        while (!deque.isEmpty()) {
            String dir = deque.pollLast();
            sb.append(dir);
            if (dir.equals("/")) {
                continue;
            }
            sb.append(++index == size - 1 ? "" : "/");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

}
