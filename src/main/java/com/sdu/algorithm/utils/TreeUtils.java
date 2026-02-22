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

package com.sdu.algorithm.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    private TreeUtils() {

    }

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int pos = 1;

        while (!queue.isEmpty()) {
            // 构建当前节点左右节点
            TreeNode node = queue.poll();

            // 左节点
            if (pos >= nodes.length) {
                break;
            }
            if (nodes[pos] != null) { // 存在
                node.left = new TreeNode(nodes[pos++]);
                queue.offer(node.left);
            } else {
                pos++;
            }

            // 右节点
            if (pos >= nodes.length) {
                break;
            }
            if (nodes[pos] != null) {
                node.right = new TreeNode(nodes[pos++]);
                queue.offer(node.right);
            } else {
                pos++;
            }
        }

        return root;
    }

    public static List<Integer> layerTravel(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.add(cur == null ? null : cur.val);
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};

        TreeNode root = buildTree(nodes);
        System.out.println(root.val);
    }

}
