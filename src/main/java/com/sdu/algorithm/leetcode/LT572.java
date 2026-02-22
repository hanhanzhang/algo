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

public class LT572 {

    private static boolean isFullSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isFullSame(s.left, t.left)
                && isFullSame(s.right, t.right);
    }

    private static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val) {
            boolean ans = isFullSame(s.left, t.left) && isFullSame(s.right, t.right);
            if (ans)
                return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {
        TreeNode s = TreeUtils.buildTree(new Integer[]{3, 4, 5, 1, 2, null, null, 0});
        TreeNode t = TreeUtils.buildTree(new Integer[]{4, 1, 2});
        System.out.println(isSubtree(s, t));

        TreeNode s1 = TreeUtils.buildTree(new Integer[]{1, 1});
        TreeNode t1 = TreeUtils.buildTree(new Integer[]{1});
        System.out.println(isSubtree(s1, t1));

        TreeNode s2 = TreeUtils.buildTree(new Integer[]{3, 4, 5, 1, null, 2});
        TreeNode t2 = TreeUtils.buildTree(new Integer[]{3, 1, 2});
        System.out.println(isSubtree(s2, t2));
    }

}
