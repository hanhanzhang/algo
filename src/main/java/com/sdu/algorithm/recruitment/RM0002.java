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

package com.sdu.algorithm.recruitment;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class RM0002 {

    private static ListNode newHead;

    private static ListNode reverseInternal(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        ListNode pre = reverseInternal(head.next);
        pre.next = head;
        return head;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        reverseInternal(head);
        head.next = null;
        return newHead;
    }

    private static ListNode reverse01(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        while (head.next != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListNode newHead = reverse(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

        System.out.println("**************");

        ListNode head1 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListNode newHead1 = reverse01(head1);
        while (newHead1 != null) {
            System.out.println(newHead1.val);
            newHead1 = newHead1.next;
        }
    }

}
