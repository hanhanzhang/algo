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

import com.sdu.algorithm.utils.Node;
import java.util.LinkedList;
import java.util.List;

public class LT589 {

    private static void preorder(Node root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, ans);
            }
        }
    }

    private List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        preorder(root, ans);
        return ans;
    }

    public static void main(String[] args) {

    }

}
