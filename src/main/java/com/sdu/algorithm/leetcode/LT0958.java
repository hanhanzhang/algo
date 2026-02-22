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

public class LT0958 {

    private static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 误忘: 每层节点数判断
        int depth = 0;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            boolean finish = false;
            int total = (int) Math.pow(2, depth);
            for (int i = 0; i < cnt; ++i) {
                TreeNode cur = queue.poll();
                // 判断左子树
                if (cur.left != null) {
                    if (finish || total > cnt)
                        return false;
                    queue.offer(cur.left);
                } else if (!finish) {
                    finish = true;
                }
                // 判断右子树
                if (cur.right != null) {
                    if (finish || total > cnt)
                        return false;
                    queue.offer(cur.right);
                } else if (!finish) {
                    finish = true;
                }
            }
            depth += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(isCompleteTree(root1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        System.out.println(isCompleteTree(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 15});
        System.out.println(isCompleteTree(root3));
    }

}
