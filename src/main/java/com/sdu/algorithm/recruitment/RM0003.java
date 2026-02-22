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

package com.sdu.algorithm.recruitment;

import java.util.Stack;

public class RM0003 {

    private static int calculate(String pattern) {
        // 可以使用双栈解决(一个栈存储数字, 一个栈存储运算符, 从后向前扫描)
        // 这里使用单栈处理, 减法变加法运算(换成负数)
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int number = 0;
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            // '+', '-', '*', '/' < '0'
            if (c >= '0') {
                number = number * 10 + c - '0';
            }

            if (c < '0') {
                switch (operator) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }
                operator = c;
                number = 0;
            }
        }

        // 计算加法
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(calculate("9/3+5*2-6"));
    }

}
