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

import java.util.HashMap;
import java.util.Map;

public class LT0290 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        int j = 0;
        for (char c : pattern.toCharArray()) {
            String word = p2s.get(c);
            String newWord = words[j++];
            if (word == null) {
                Character ch = s2p.get(newWord);
                if (ch != null) {
                    return false;
                }
                s2p.put(newWord, c);
                p2s.put(c, newWord);
            } else if (!newWord.equals(word)) {
                return false;
            }
        }
        return j == words.length;
    }

    public static void main(String[] args) {
        LT0290 lt = new LT0290();
        System.out.println(lt.wordPattern("abba", "dog cat cat fish"));
        System.out.println(lt.wordPattern("abba", "dog cat cat dog"));
    }
}
