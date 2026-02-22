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

public class OR024 {

    // 反转链表
    private static ListNode reverseList(ListNode head) {
        ListNode dumpNode = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = dumpNode.next;
            dumpNode.next = cur;
            cur = tmp;
        }
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        ListUtils.printListNode(reverseList(head));
    }

}
