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

public class LT0019 {

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑巴节点, 预防删除第一个节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head, second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListUtils.printListNode(removeNthFromEnd(head1, 2));

        ListNode head2 = ListUtils.buildListNode(new Integer[]{1});
        ListUtils.printListNode(removeNthFromEnd(head2, 1));
    }

}
