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

public class LT0129 {

    private static int sumNumbers(TreeNode root, int pathSum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return pathSum * 10 + root.val;
        }
        // 左子树
        int leftSum = sumNumbers(root.left, pathSum * 10 + root.val);
        int rightSum = sumNumbers(root.right, pathSum * 10 + root.val);
        return leftSum + rightSum;
    }

    private static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{4, 9, 0, 5, 1});
        System.out.println(sumNumbers(root));
    }

}
