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

import com.sdu.algorithm.utils.TreeUtils;
import com.sdu.algorithm.utils.TreeNode;

public class LT450 {

    private static TreeNode adjustTree(TreeNode left, TreeNode right) {
        // 已左子树为根节点, 右子树的所有值都比左子树的值大, 故遍历右子树
        if (left == null) {
            return right;
        }
        if (left.right == null) {
            left.right = right;
            return left;
        }
        adjustTree(left.right, right);
        return left;
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            return adjustTree(root.left, root.right);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        root.right = deleteNode(root.right, key);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode newRoot = deleteNode(root, 3);
        System.out.println(newRoot.val);

        TreeNode root2 = TreeUtils.buildTree(new Integer[]{3, 1, 4, null, 2});
        TreeNode newRoot2 = deleteNode(root2, 3);
        System.out.println(newRoot2.val);
    }

}
