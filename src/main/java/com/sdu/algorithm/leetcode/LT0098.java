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

public class LT0098 {

    private static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println(isValidBST(root1));

        TreeNode root2 = TreeUtils.buildTree(new Integer[]{5, 1, 7, null, null, 6, 8});
        System.out.println(isValidBST(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[]{2, 1, 3});
        System.out.println(isValidBST(root3));

        TreeNode root4 = TreeUtils.buildTree(new Integer[]{1, 1});
        System.out.println(isValidBST(root4));

        TreeNode root5 = TreeUtils.buildTree(new Integer[]{Integer.MAX_VALUE});
        System.out.println(isValidBST(root5));
    }

}
