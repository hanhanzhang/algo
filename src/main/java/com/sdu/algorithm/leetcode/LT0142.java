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

public class LT0142 {

    private static ListNode detectCycle(ListNode head) {
        // D
        // +----+----+
        // | |
        // +-------+---------+
        // A B
        // 相遇点: D, 则 2(AB + BD) = AB + BD + DB + BD
        // 可得出: AB = DB
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);

        ListNode node2 = new ListNode(2);
        root.next = node2;

        ListNode node0 = new ListNode(0);
        node2.next = node0;

        ListNode node4 = new ListNode(-4);
        node0.next = node4;
        node4.next = node2;

        System.out.println(detectCycle(root));
    }

}
