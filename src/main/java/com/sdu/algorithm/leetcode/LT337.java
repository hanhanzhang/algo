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
import com.sdu.algorithm.utils.TreeUtils;

public class LT337 {

    private static int rob(TreeNode root) {
        /*
         * 二叉树的动态规划题, 有两种情况:
         *
         * 1: 从根节点打劫
         *
         * 2: 不从根节点打劫, 计算以孩子节点为根节点的二叉树的所有数值和
         *
         * NOTE: 计算效率低, 可用空间换时间, 保留中间计算的结果
         */

        if (root == null)
            return 0;

        // 第一种情况, 从根节点打劫
        int rootSum = root.val;
        if (root.left != null) {
            rootSum += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            rootSum += rob(root.right.left) + rob(root.right.right);
        }

        // 第二种情况, 不从根节点打劫
        int childSum = 0;
        childSum += rob(root.left) + rob(root.right);

        return Math.max(rootSum, childSum);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[]{3, 2, 3, null, 3, null, 1});
        System.out.println(rob(root1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[]{3, 4, 5, 1, 3, null, 1});
        System.out.println(rob(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[]{1, null, 2});
        System.out.println(rob(root3));
    }

}
