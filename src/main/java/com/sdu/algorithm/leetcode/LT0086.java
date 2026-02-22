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

public class LT0086 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode();
        ListNode curSmall = dummySmall;
        ListNode dummyLarge = new ListNode();
        ListNode curLarge = dummyLarge;
        dummyLarge.next = curLarge;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curLarge.next = null;
        curSmall.next = dummyLarge.next;
        return dummySmall.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[]{1, 4, 3, 2, 5, 2});
        LT0086 lt = new LT0086();
        ListNode newHead = lt.partition(head, 3);
        ListUtils.printListNode(newHead);
    }
}
