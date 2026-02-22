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

public class LT0148II {

    private static ListNode quickSort(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return head;
        }

        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null && cur != tail) {
            if (cur.val < head.val) {
                ListNode tmp = cur.next;
                cur.next = dumpNode.next;
                dumpNode.next = cur;
                cur = tmp;
                pre.next = tmp;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        // 排左侧
        ListNode left = quickSort(dumpNode.next, head);
        // 排右侧
        head.next = quickSort(head.next, tail);

        return left;
    }

    private static ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[]{4, 2, 1, 3});
        ListUtils.printListNode(sortList(head1));

        ListNode head2 = ListUtils.buildListNode(new Integer[]{8, 9, 5, 10, 3});
        ListUtils.printListNode(sortList(head2));

        ListNode head3 = ListUtils.buildListNode(new Integer[]{-1, 5, 3, 4, 0});
        ListUtils.printListNode(sortList(head3));

        ListNode head4 = ListUtils.buildListNode(new Integer[]{});
        ListUtils.printListNode(sortList(head4));
    }

}
