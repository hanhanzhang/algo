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

public class LT0105 {

    private static TreeNode buildTree(int[] preorder, int index, int[] inorders, int start, int end) {
        if (start > end)
            return null;

        TreeNode root = new TreeNode(preorder[index]);
        int divideLine = start;
        for (; divideLine < end; ++divideLine) {
            if (inorders[divideLine] == preorder[index]) {
                break;
            }
        }
        // 建立左子树, 中序区间(start, divideLine - 1)
        root.left = buildTree(preorder, index + 1, inorders, start, divideLine - 1);
        // 建立右子树, 中序区间(divideLine + 1, end)
        root.right = buildTree(preorder, index + (divideLine - start + 1), inorders, divideLine + 1, end);
        return root;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
    }

}
