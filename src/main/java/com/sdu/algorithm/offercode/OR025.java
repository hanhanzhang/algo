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

package com.sdu.algorithm.offercode;

import com.sdu.algorithm.utils.ListNode;
import com.sdu.algorithm.utils.ListUtils;

public class OR025 {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode(-1);
        ListNode cur = dumpNode;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
        }

        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode h1 = ListUtils.buildListNode(new Integer[]{1, 2, 4});
        ListNode h2 = ListUtils.buildListNode(new Integer[]{1, 3, 4});
        ListUtils.printListNode(mergeTwoLists(h1, h2));
    }
}
