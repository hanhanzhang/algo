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

public class LT0543 {

//    private static int treeHeight(TreeNode root) {
//        if (root == null)
//            return 0;
//        int left = treeHeight(root.left) + 1;
//        int right = treeHeight(root.right) + 1;
//        return Math.max(left, right);
//    }
//
//    private static int diameterOfBinaryTree(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int max = -1;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                continue;
//            }
//            queue.offer(node.left);
//            queue.offer(node.right);
//            int len = treeHeight(node.left) + treeHeight(node.right) + 1;
//
//            if (len > max)
//                max = len;
//
//        }
//        return max - 1;
//    }

    private int maxLen;

    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);
        maxLen = Math.max(maxLen, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        treeHeight(root);
        return maxLen;
    }

    public static void main(String[] args) {
        LT0543 lt = new LT0543();
        TreeNode root = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(lt.diameterOfBinaryTree(root));
    }

}
