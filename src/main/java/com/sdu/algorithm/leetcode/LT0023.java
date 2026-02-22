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

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

import java.util.PriorityQueue;

public class LT0023 {

    public static class Solution1 {

        private static ListNode mergeKLists(ListNode[] lists) {
            // 哑巴节点
            ListNode dumpNode = new ListNode(0);
            ListNode cur = dumpNode;

            int[] visited = new int[lists.length];
            int remains = lists.length;

            while (remains != 0) {
                ListNode minNode = null;
                int pos = 0;
                for (int i = 0; i < lists.length; ++i) {
                    if (visited[i] == 1) {
                        continue;
                    }
                    ListNode node = lists[i];
                    if (node == null) {
                        visited[i] = 1;
                        remains -= 1;
                        continue;
                    }
                    if (remains == 1) {
                        minNode = node;
                        pos = i;
                        remains = 0;
                        break;
                    }
                    if (minNode == null) {
                        minNode = node;
                        pos = i;
                    } else if (minNode.val > node.val) {
                        minNode = node;
                        pos = i;
                    }
                }
                cur.next = minNode;
                cur = minNode;
                lists[pos] = lists[pos] != null ? lists[pos].next : null;
            }

            return dumpNode.next;
        }
    }

    public static class Solution2 {

        private static ListNode mergeTwoList(ListNode n1, ListNode n2) {
            ListNode dumpNode = new ListNode(0);
            ListNode cur = dumpNode;

            while (n1 != null || n2 != null) {
                if (n1 != null && n2 != null) {
                    if (n1.val <= n2.val) {
                        cur.next = n1;
                        cur = n1;
                        n1 = n1.next;
                    } else {
                        cur.next = n2;
                        cur = n2;
                        n2 = n2.next;
                    }
                } else {
                    cur.next = n1 == null ? n2 : n1;
                    break;
                }
            }

            return dumpNode.next;
        }

        private static ListNode mergeKLists(ListNode[] lists) {
            // 两两归并(耗时最低)
            int remains = lists.length;
            if (remains == 0) {
                return null;
            }
            while (remains != 1) {
                int len = lists.length / 2 + lists.length % 2;
                ListNode[] ans = new ListNode[len];
                int low = 0, high = lists.length - 1;
                int pos = 0;
                while (low < high) {
                    ans[pos++] = mergeTwoList(lists[low++], lists[high--]);
                }
                if (low == high) {
                    ans[pos] = lists[low];
                }
                lists = ans;
                remains = len;
            }
            return lists[0];
        }
    }

    public static class Solution3 {

        private static ListNode mergeKLists(ListNode[] lists) {
            // 优先队列
            PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
            for (ListNode node : lists) {
                if (node == null) {
                    continue;
                }
                queue.offer(node);
            }
            // 哑巴节点
            ListNode dumpNode = new ListNode(0);
            ListNode cur = dumpNode;

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                cur.next = node;
                cur = node;
                node = node.next;
                if (node != null) {
                    queue.offer(node);
                }
            }

            return dumpNode.next;
        }

    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[]{
                ListUtils.buildListNode(new Integer[]{1, 4, 5}),
                ListUtils.buildListNode(new Integer[]{1, 3, 4}),
                ListUtils.buildListNode(new Integer[]{2, 6})
        };

        ListNode head = Solution1.mergeKLists(nodes);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("************************************");

        ListNode[] nodes02 = new ListNode[]{
                ListUtils.buildListNode(new Integer[]{1, 4, 5}),
                ListUtils.buildListNode(new Integer[]{1, 3, 4}),
                ListUtils.buildListNode(new Integer[]{2, 6})
        };

        ListNode head02 = Solution2.mergeKLists(nodes02);
        while (head02 != null) {
            System.out.println(head02.val);
            head02 = head02.next;
        }

        System.out.println("************************************");

        ListNode[] nodes03 = new ListNode[]{
                ListUtils.buildListNode(new Integer[]{1, 4, 5}),
                ListUtils.buildListNode(new Integer[]{1, 3, 4}),
                ListUtils.buildListNode(new Integer[]{2, 6})
        };

        ListNode head03 = Solution3.mergeKLists(nodes03);
        while (head03 != null) {
            System.out.println(head03.val);
            head03 = head03.next;
        }
    }

}
