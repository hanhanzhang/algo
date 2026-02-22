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

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LT0017 {

    private static final Map<Character, String> phone = new HashMap<Character, String>() {

        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    private static void letterCombinations(String digits, int digitPos, char[] subChars, List<String> result) {
        if (digitPos >= digits.length()) {
            result.add(new String(subChars));
            return;
        }
        // 'a' = 97
        char c = digits.charAt(digitPos);
        char[] letters = phone.get(c).toCharArray();
        for (char letter : letters) {
            subChars[digitPos] = letter;
            letterCombinations(digits, digitPos + 1, subChars, result);
        }
    }

    private static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return Collections.emptyList();
        char[] subChars = new char[digits.length()];
        List<String> result = new LinkedList<>();
        letterCombinations(digits, 0, subChars, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("24"));
    }

}
