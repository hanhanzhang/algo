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
import java.util.LinkedList;
import java.util.Queue;

public class LT0124 {

    private static int maxSum(TreeNode start, TreeNode current) {
        if (current == null)
            return 0;
        int leftTreeMaxSum = maxSum(start, current.left);
        int rightTreeMaxSum = maxSum(start, current.right);

        if (start == current) {
            return start.val + Math.max(leftTreeMaxSum, 0) + Math.max(rightTreeMaxSum, 0);
        }

        return current.val + Math.max(0, Math.max(leftTreeMaxSum, rightTreeMaxSum));
    }

    private static int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        // 对每个节点都求最大值, 在所有节点中选取最大值
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            // 对于根节点, 是需要累加左子树和右子树的和, 递归遍历其他节点只需要选择一遍,
            // 故使用start, current用于标识是否退回到跟节点, 回溯
            int maxSum = maxSum(node, node);
            max = maxSum > max ? maxSum : max;
        }

        return max;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(maxPathSum(root1));

        TreeNode root2 =
                TreeUtils.buildTree(new Integer[]{9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6});
        System.out.println(maxPathSum(root2));
    }

}
