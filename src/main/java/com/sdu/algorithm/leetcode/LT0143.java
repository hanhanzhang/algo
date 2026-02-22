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

import java.util.Stack;

public class LT0143 {

    private static void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        ListNode ret = head, tail = stack.pop();
        while (ret != null) {
            if (ret.next == tail || ret == tail) {
                break;
            }
            ListNode ops = ret.next;
            ret.next = tail;
            tail.next = ops;
            ret = ops;
            tail = stack.pop();
        }
        tail.next = null;
    }

    public static void main(String[] args) {
        ListNode head1 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4});
        reorderList(head1);
        ListUtils.printListNode(head1);

        ListNode head2 = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        reorderList(head2);
        ListUtils.printListNode(head2);
    }

}
