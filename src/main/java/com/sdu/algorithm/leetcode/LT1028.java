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

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT1028 {

    private static int getNextPosition(char[] chars, int i) {
        for (int j = i; j < chars.length; ++j) {
            if (chars[j] == '-') {
                return j - 1;
            }
        }
        return chars.length - 1;
    }

    private static int getNumber(char[] chars, int i, int j) {
        int sum = Character.getNumericValue(chars[i]);
        for (int k = i + 1; k <= j; ++k) {
            sum = sum * 10 + Character.getNumericValue(chars[k]);
        }
        return sum;
    }

    public static TreeNode recoverFromPreorder(String S) {
        if (S == null || S.isEmpty()) {
            return null;
        }
        Map<TreeNode, TreeNode> childToParents = new HashMap<>();
        Map<TreeNode, Integer> nodeToDepths = new HashMap<>();
        char[] chars = S.toCharArray();
        int depth = 0;
        TreeNode root = null;
        TreeNode pre = null;
        int i = 0;
        while (i < chars.length) {
            if (i == 0) {
                int j = getNextPosition(chars, i);
                int num = getNumber(chars, i, j);
                i = j + 1;
                root = new TreeNode(num);
                nodeToDepths.put(root, 0);
                pre = root;
                continue;
            }
            if (chars[i] == '-') {
                i += 1;
                depth += 1;
                continue;
            }
            int j = getNextPosition(chars, i);
            int num = getNumber(chars, i, j);
            i = j + 1;
            TreeNode node = new TreeNode(num);
            // 若是当前节点的深度比前个节点深度要大, 则为前个节点的左孩子
            // 若是当前节点的深度比前个节点深度要小(或相等), 则为某个前节点的右孩子
            int preDepth = nodeToDepths.get(pre);
            if (depth > preDepth) {
                pre.left = node;
            } else {
                // 深度比当前节点小的节点
                while (preDepth >= depth) {
                    pre = childToParents.get(pre);
                    preDepth = nodeToDepths.get(pre);
                }
                pre.right = node;
            }
            childToParents.put(node, pre);
            nodeToDepths.put(node, depth);
            pre = node;
            depth = 0;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = recoverFromPreorder("1-2--3--4-5--6--7");
        List<Integer> res1 = TreeUtils.layerTravel(root1);
        ListUtils.printList(res1);

        TreeNode root2 = recoverFromPreorder("1-2--3---4-5--6---7");
        List<Integer> res2 = TreeUtils.layerTravel(root2);
        ListUtils.printList(res2);

        TreeNode root3 = recoverFromPreorder("1-401--349---90--88");
        List<Integer> res3 = TreeUtils.layerTravel(root3);
        ListUtils.printList(res3);
    }

}
