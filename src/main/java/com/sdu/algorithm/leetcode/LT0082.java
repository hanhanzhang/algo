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

public class LT0082 {

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 哨兵
        ListNode dumpNode = new ListNode(-1);
        ListNode cur = dumpNode;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            while (fast != null && fast.val == slow.val)
                fast = fast.next;
            if (slow.next == fast) {
                cur.next = slow;
                cur = slow;
            }
            slow = fast;
            fast = fast != null ? fast.next : null;
        }
        cur.next = slow;
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        ListUtils.printListNode(deleteDuplicates(head1));

        ListNode head2 = ListUtils.buildListNode(new Integer[]{1, 1, 1, 2, 3});
        ListUtils.printListNode(deleteDuplicates(head2));

        ListNode head3 = ListUtils.buildListNode(new Integer[]{1, 1});
        ListUtils.printListNode(deleteDuplicates(head3));
    }
}
