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

public class OR026 {

    private static boolean isSubStructure(TreeNode A, TreeNode B, TreeNode origin) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val
                && isSubStructure(A.left, B.left, origin)
                && isSubStructure(A.right, B.right, origin)) {
            return true;
        }
        return isSubStructure(A.left, origin, origin) || isSubStructure(A.right, origin, origin);
    }

    private static boolean isSubStructure(TreeNode A, TreeNode B) {
        // TODO: 2021/3/31 相同的结构, 遍历结果肯定为子串
        if (B == null || A == null) {
            return false;
        }
        return isSubStructure(A, B, B);
    }

    public static void main(String[] args) {
        TreeNode A1 = TreeUtils.buildTree(new Integer[]{1, 2, 3});
        TreeNode B1 = TreeUtils.buildTree(new Integer[]{3, 1});
        System.out.println(isSubStructure(A1, B1));

        TreeNode A2 = TreeUtils.buildTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode B2 = TreeUtils.buildTree(new Integer[]{4, 1});
        System.out.println(isSubStructure(A2, B2));
    }

}
