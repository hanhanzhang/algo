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

public class LT0297 {

    private static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (first) {
                sb.append(node == null ? "NULL" : node.val);
                first = false;
            } else {
                sb.append("#");
                sb.append(node == null ? "NULL" : node.val);
            }

            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        String[] nodes = data.split("#");
        if (nodes[0].equals("NULL")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;
        while (!queue.isEmpty() && cur < nodes.length) {
            TreeNode node = queue.poll();
            // 左子树
            if (nodes[cur].equals("NULL")) {
                cur += 1;
                node.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[cur++]));
                node.left = left;
                queue.offer(left);
            }
            // 右子树
            if (cur < nodes.length) {
                if (nodes[cur].equals("NULL")) {
                    cur += 1;
                    node.right = null;
                } else {
                    TreeNode right = new TreeNode(Integer.parseInt(nodes[cur++]));
                    node.right = right;
                    queue.offer(right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{1, 2, 3, null, null, 4, 5, 6, 7});
        String data = serialize(root);
        System.out.println(data);

        TreeNode root1 = deserialize(data);
        System.out.println(root1.val);
    }

}
