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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LT0095 {

    private static List<TreeNode> buildTree(int start, int end) {
        if (start > end) {
            return Collections.emptyList();
        }

        List<TreeNode> res = new LinkedList<>();
        for (int i = start; i <= end; ++i) {
            // 构建左子树
            List<TreeNode> leftRes = buildTree(start, i - 1);
            // 构建右子树
            List<TreeNode> rightRes = buildTree(i + 1, end);
            if (!leftRes.isEmpty() && !rightRes.isEmpty()) {
                for (TreeNode leftNode : leftRes) {
                    for (TreeNode rightNode : rightRes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
            } else if (!leftRes.isEmpty()) {
                for (TreeNode leftNode : leftRes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    res.add(root);
                }
            } else if (!rightRes.isEmpty()) {
                for (TreeNode rightNode : rightRes) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightNode;
                    res.add(root);
                }
            } else {
                res.add(new TreeNode(i));
            }
        }

        return res;
    }

    private static List<TreeNode> generateTrees(int n) {
        // 有序列表组合问题
        return buildTree(1, n);
    }

    public static void main(String[] args) {
        List<TreeNode> searchTrees = generateTrees(3);
        for (TreeNode root : searchTrees) {
            System.out.println(TreeUtils.layerTravel(root));
        }
    }

}
