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

package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OR054 {

    private static int kthLargest(TreeNode root, int k) {
        List<Integer> ret = new ArrayList<>();
        // 中序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            root = node.right;
        }
        return ret.get(ret.size() - k);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[]{3, 1, 4, null, 2});
        System.out.println(kthLargest(root1, 1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(kthLargest(root2, 3));
    }

}
