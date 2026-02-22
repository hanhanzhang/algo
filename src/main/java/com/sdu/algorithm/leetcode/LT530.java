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

public class LT530 {

    private static int pre;
    private static int minDif;

    private static int getMinimumDifference(TreeNode root) {
        pre = -1;
        minDif = Integer.MAX_VALUE;
        inOrder(root);
        return minDif;
    }

    private static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre != -1)
            minDif = Math.min(minDif, root.val - pre);
        pre = root.val;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{1, null, 3, 2});
        System.out.println(getMinimumDifference(root));

        TreeNode root2 = TreeUtils.buildTree(new Integer[]{543, 384, 652, null, 445, null, 699});
        System.out.println(getMinimumDifference(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[]{0, null, 2236, 1277, 2776, 519});
        System.out.println(getMinimumDifference(root3));

        TreeNode root4 = TreeUtils.buildTree(new Integer[]{5, 4, 7});
        System.out.println(getMinimumDifference(root4));
    }

}
