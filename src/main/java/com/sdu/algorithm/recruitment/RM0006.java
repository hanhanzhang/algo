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

import com.sdu.algorithm.utils.TreeNode;
import java.util.Arrays;

public class RM0006 {

    private static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,
                                      int postEnd) {
        // 5, 6, 7, 8, 10(中)
        // 5, 8, 10, 7, 6(后)
        if (postEnd < postStart || inEnd < inStart) {
            return null;
        }
        // 确定根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = -1;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == postorder[postEnd]) {
                pos = i;
                break;
            }
        }
        int rightLen = inEnd - pos;
        // 构建左子树
        root.left = buildTree(inorder, postorder, inStart, pos - 1, postStart, postEnd - rightLen - 1);
        // 构建右子树
        root.right = buildTree(inorder, postorder, pos + 1, inEnd, postEnd - rightLen, postEnd - 1);
        return root;
    }
    private static TreeNode buildTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        // copy
        int[] inorder = new int[array.length];
        System.arraycopy(array, 0, inorder, 0, array.length);
        // 数组排序
        Arrays.sort(inorder);
        return buildTree(inorder, array, 0, inorder.length - 1, 0, array.length - 1);
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{5, 8, 10, 7, 6});
        System.out.println(root.val);
    }

}
