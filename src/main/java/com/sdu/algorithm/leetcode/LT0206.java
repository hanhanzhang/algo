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

public class LT0206 {

    public static class Solution1 {

        private static ListNode reverseList(ListNode head) {
            // 哑巴节点
            ListNode dumpNode = new ListNode(0);
            while (head != null) {
                ListNode temp = dumpNode.next;
                dumpNode.next = head;
                head = head.next;
                dumpNode.next.next = temp;
            }
            return dumpNode.next;
        }

    }

    public static class Solution2 {

        private static ListNode newHead;

        private static ListNode reverse(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode next = reverse(head.next);
            if (next == null) {
                newHead = head;
                return head;
            }
            next.next = head;
            return head;
        }

        private static ListNode reverseList(ListNode head) {
            reverse(head);
            head.next = null;
            return newHead;
        }

    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListNode reverseHead1 = Solution1.reverseList(head1);
        while (reverseHead1 != null) {
            System.out.println(reverseHead1.val);
            reverseHead1 = reverseHead1.next;
        }
        System.out.println("********************");

        ListNode head2 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListNode reverseHead2 = Solution2.reverseList(head2);
        while (reverseHead2 != null) {
            System.out.println(reverseHead2.val);
            reverseHead2 = reverseHead2.next;
        }

    }

}
