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

public class LT0084M {

    private static int largestRectangleArea(int[] heights) {
        // 单调递增栈
        // 对于每个元素勾勒的最大矩形需要向左和向右找到第一个比当前元素最小的值
        // 元素需要先进入栈保留, 当发现后面元素比栈顶元素小时, 说明向右找到第一个最小值元素, 需弹栈
        // 使用'哨兵'方便边界的处理, 特别是在链表中的使用
        if (heights == null || heights.length == 0)
            return 0;
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i <= heights.length; ++i) {
            newHeights[i] = heights[i - 1];
        }
        // 存放下标, 计算宽度
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int area = 0;
        for (int i = 1; i < newHeights.length; ++i) {
            // 栈顶元素比当前元素大, 则向右找到第一个比栈顶元素小的值, 计算栈顶勾勒最大矩形
            while (newHeights[stack.peek()] > newHeights[i]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;
                area = Math.max(height * width, area);
            }
            // 当前元素进栈, 等待右边第一个比其小的元素
            stack.push(i);
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 4}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));
    }

}
