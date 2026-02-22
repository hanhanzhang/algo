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

public class LT0205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Character replaced1 = map1.get(c1);
            if (replaced1 != null && replaced1 != c2) {
                return false;
            }
            Character replaced2 = map2.get(c2);
            if (replaced2 != null && replaced2 != c1) {
                return false;
            }
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        LT0205 lt = new LT0205();
        System.out.println(lt.isIsomorphic("badc", "baba"));
    }

}
