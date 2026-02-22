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

public class LT0002 {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode(0);
        ListNode cur = dumpNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtils.buildListNode(new Integer[]{2, 4, 3});
        ListNode l2 = ListUtils.buildListNode(new Integer[]{5, 6, 4});

        ListNode head = addTwoNumbers(l1, l2);

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

}
