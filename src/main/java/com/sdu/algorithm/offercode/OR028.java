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

import static com.sdu.algorithm.utils.TreeUtils.buildTree;

public class OR028 {

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }
        return false;
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(isSymmetric(buildTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }

}
