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

public class LT0124II {

    private static Integer maxSum = Integer.MIN_VALUE;

    private static int intervalMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树
        int leftMaxSum = intervalMaxPathSum(root.left);
        // 右子树
        int rightMaxSum = intervalMaxPathSum(root.right);

        int val = leftMaxSum + rightMaxSum + root.val;
        int ret = Math.max(root.val, Math.max(leftMaxSum, rightMaxSum) + root.val);
        maxSum = Math.max(val, ret) > maxSum ? Math.max(val, ret) : maxSum;

        return ret;
    }

    private static int maxPathSum(TreeNode root) {
        intervalMaxPathSum(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(maxPathSum(root1));

        TreeNode root2 =
                TreeUtils.buildTree(new Integer[]{9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6});
        System.out.println(maxPathSum(root2));

        TreeNode root3 = TreeUtils.buildTree(new Integer[]{0});
        System.out.println(maxPathSum(root3));
    }

}
