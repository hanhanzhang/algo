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

public class LT0021 {

    private static ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        // 哑巴节点
        ListNode dumpNode = new ListNode(0);
        ListNode cur = dumpNode;
        while (n1 != null || n2 != null) {
            if (n1 != null && n2 != null) {
                if (n1.val <= n2.val) {
                    cur.next = n1;
                    cur = n1;
                    n1 = n1.next;
                } else {
                    cur.next = n2;
                    cur = n2;
                    n2 = n2.next;
                }
            } else {
                cur.next = n1 == null ? n2 : n1;
                break;
            }
        }
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode n1 = ListUtils.buildListNode(new Integer[]{1, 2, 4});
        ListNode n2 = ListUtils.buildListNode(new Integer[]{1, 3, 4});
        ListNode head = mergeTwoLists(n1, n2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
