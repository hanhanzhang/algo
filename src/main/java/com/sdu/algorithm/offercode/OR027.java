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

import com.sdu.algorithm.utils.ListUtils;
import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class OR027 {

    private static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode newRoot = mirrorTree(root);
        ListUtils.printList(TreeUtils.layerTravel(newRoot));
    }

}
