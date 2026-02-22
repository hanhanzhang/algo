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

public class LT0148 {

    private static ListNode sortList(ListNode head) {
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode cur = head;
        while (cur != null) {
            ListNode ret = cur.next;
            if (ret == null) {
                break;
            }
            if (cur.val <= ret.val) {
                cur = cur.next;
            } else {
                cur.next = ret.next;
                // (dumpNode, cur)寻找第一个比ret节点大的节点
                ListNode pos = dumpNode.next;
                ListNode pre = dumpNode;
                while (pos != cur) {
                    if (pos.val < ret.val) {
                        pre = pos;
                        pos = pos.next;
                    } else {
                        break;
                    }
                }
                ret.next = pos;
                pre.next = ret;
            }
        }
        return dumpNode.next;
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
