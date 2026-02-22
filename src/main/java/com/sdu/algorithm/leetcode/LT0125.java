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

public class LT0125 {

    private static boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            while (low < high && !Character.isLetterOrDigit(s.charAt(low)))
                low += 1;
            while (low < high && !Character.isLetterOrDigit(s.charAt(high)))
                high -= 1;
            if (low < high) {
                if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                    return false;
                }
                low += 1;
                high -= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

}
