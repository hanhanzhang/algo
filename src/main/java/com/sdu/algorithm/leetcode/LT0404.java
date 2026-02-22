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

public class LT0404 {

    private static int sumOfLeftLeavesInternal(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        return sumOfLeftLeavesInternal(root.left, true)
                + sumOfLeftLeavesInternal(root.right, false);
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesInternal(root, false);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(sumOfLeftLeaves(root));
    }

}
