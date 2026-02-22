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

public class RM0005 {

    private static ListNode merge(ListNode n1, ListNode n2) {
        // 有序链表合并
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (n1 != null || n2 != null) {
            Integer c1 = n1 == null ? null : n1.val;
            Integer c2 = n2 == null ? null : n2.val;

            if (c1 != null && c2 != null) {
                if (c1 < c2) {
                    cur.next = n1;
                    cur = n1;
                    n1 = n1.next;
                } else {
                    cur.next = n2;
                    cur = n2;
                    n2 = n2.next;
                }
            } else if (c1 != null) {
                cur.next = n1;
                break;
            } else {
                cur.next = n2;
                break;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = ListUtils.buildListNode(new Integer[]{1, 3, 5});
        ListNode n2 = ListUtils.buildListNode(new Integer[]{2, 4, 5});

        ListNode head = merge(n1, n2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
