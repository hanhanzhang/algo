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

public class LT387 {

    private static int firstUniqChar(String s) {
        if (s == null || s.isEmpty())
            return -1;
        // 若char出现多次, 标识为-2
        int[][] charCnt = new int[26][1];
        for (int i = 0; i < 26; ++i) {
            charCnt[i] = new int[]{-1};
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int pos = c - 'a';
            if (charCnt[pos][0] == -1) { // 尚未出现过
                charCnt[pos][0] = i;
            } else if (charCnt[pos][0] >= 0) { // 已出现过
                charCnt[pos][0] = -2;
            }
        }

        int minPos = s.length();
        for (int i = 0; i < charCnt.length; ++i) {
            if (charCnt[i][0] >= 0 && charCnt[i][0] < minPos) {
                // 出现仅一次
                minPos = charCnt[i][0];
            }
        }
        return minPos == s.length() ? -1 : minPos;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

}
