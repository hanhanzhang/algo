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

public class LT0092 {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        // 头节点有可能发生变化(若left=1, 则头部节点发生变化),使用虚拟头节点可以避免复杂的分类讨论
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode pre = dumpNode;
        for (int i = 0; i < left - 1; ++i) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode reverseHead = cur;
        // 反转列表
        for (int i = left; i < right && cur.next != null; ++i) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = reverseHead;
            reverseHead = tmp;
        }
        pre.next = reverseHead;
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListNode newHead = reverseBetween(head, 2, 4);
        ListUtils.printListNode(newHead);
    }

}
