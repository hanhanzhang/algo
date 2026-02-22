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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OR034 {

    private static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> ret = new LinkedList<>();
        if (root.left == null && root.right == null) {
            if (root.val != target)
                return Collections.emptyList();

            List<Integer> subPath = new LinkedList<>();
            subPath.add(root.val);
            ret.add(subPath);
            return ret;
        }

        List<List<Integer>> leftPath = pathSum(root.left, target - root.val);
        List<List<Integer>> rightPath = pathSum(root.right, target - root.val);
        for (List<Integer> subPath : leftPath) {
            LinkedList<Integer> subPaths = (LinkedList<Integer>) subPath;
            subPaths.addFirst(root.val);
            ret.add(subPath);
        }
        for (List<Integer> subPath : rightPath) {
            LinkedList<Integer> subPaths = (LinkedList<Integer>) subPath;
            subPaths.addFirst(root.val);
            ret.add(subPath);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> paths = pathSum(root, 22);
        System.out.println(paths);
    }

}
