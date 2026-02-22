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
import java.util.ArrayDeque;
import java.util.Queue;

public class LT559 {

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        int depth = 0;
        int cur = 1;
        int next = 0;
        int visit = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit += 1;
            if (node.children != null) {
                for (Node cn : node.children) {
                    next += 1;
                    queue.offer(cn);
                }
            }

            if (visit == cur) {
                depth += 1;
                cur = next;
                visit = 0;
                next = 0;
            }
        }

        return depth;
    }

    public static void main(String[] args) {

    }

}
