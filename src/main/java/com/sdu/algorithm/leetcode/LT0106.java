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

import com.sdu.algorithm.utils.TreeNode;

public class LT0106 {

    private static TreeNode buildTree(int[] postorder, int index, int[] inorder, int start, int end) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(postorder[index]);
        int divideLine = start;
        for (; divideLine < end; ++divideLine) {
            if (inorder[divideLine] == postorder[index]) {
                break;
            }
        }

        // 建立右子树, 中序区间(divideLine + 1, end)
        root.right = buildTree(postorder, index - 1, inorder, divideLine + 1, end);
        // 建立左子树, 中序区间(start, divideLine - 1)
        root.left = buildTree(postorder, index - (end - divideLine + 1), inorder, start, divideLine - 1);
        return root;
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
         * 前序和中序建立二叉树, 以前序列表建树(从前遍历), 划分中序列表 后序和中序建立二叉树, 以后序列表建树(从后遍历), 划分中序列表
         */
        return buildTree(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root.val);
    }

}
