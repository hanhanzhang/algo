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

public class LT0096M {

    // 这种方式提交, 超时
    private static int buildTree(int start, int end) {
        if (start > end) {
            return 0;
        }
        int res = 0;
        for (int i = start; i <= end; ++i) {
            // 构建左子树
            int leftTreeNum = buildTree(start, i - 1);
            // 构建右子树
            int rightTreeNum = buildTree(i + 1, end);
            if (leftTreeNum != 0 && rightTreeNum != 0) {
                res += leftTreeNum * rightTreeNum;
            } else if (leftTreeNum != 0) {
                res += leftTreeNum;
            } else if (rightTreeNum != 0) {
                res += rightTreeNum;
            } else {
                res += 1;
            }
        }
        return res;
    }

    private static int numTrees(int n) {
        // return buildTree(1, n);
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

}
