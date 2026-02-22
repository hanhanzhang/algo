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

public class LT0415 {

    private static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? (num1.charAt(i--) - '0') : 0;
            int y = j >= 0 ? (num2.charAt(j--) - '0') : 0;
            int sum = x + y + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }
        return ans.reverse().toString();
    }

    private static String subStrings(String num1, String num2) {
        // 计算结果
        boolean negative = false;
        int[] ans = new int[Math.max(num1.length(), num2.length())];

        // STEP1: 判断字符串大小
        if (num1.length() == num2.length()) {
            int ret = num1.compareTo(num2);
            if (ret == 0) {
                return "0";
            } else if (ret < 1) {
                negative = true;
                String tmp = num1;
                num1 = num2;
                num2 = tmp;
            }
        } else if (num1.length() < num2.length()) {
            negative = true;
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        // STEP2: 字符串相减法
        int n1 = num1.length() - 1, n2 = num2.length() - 1, borrow = 0;
        while (n1 >= 0 || n2 >= 0) {
            int x1 = num1.charAt(n1) - '0' - borrow;
            int x2 = n2 >= 0 ? num2.charAt(n2--) - '0' : 0;
            if (x1 < x2) {
                borrow = 1;
                ans[n1--] = 10 + x1 - x2;
            } else {
                borrow = 0;
                ans[n1--] = x1 - x2;
            }
        }

        StringBuilder ret = new StringBuilder(negative ? "-" : "");
        boolean alreadyAdd = false;
        for (int i = 0; i < ans.length; ++i) {
            if (ans[i] == 0 && alreadyAdd) {
                ret.append(ans[i]);
            } else if (ans[i] != 0) {
                alreadyAdd = true;
                ret.append(ans[i]);
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("12", "23"));
        System.out.println(addStrings("13", "99"));

        System.out.println(subStrings("1236", "1235"));
        System.out.println(subStrings("88", "1000"));
        System.out.println(subStrings("88", "88"));
    }

}
