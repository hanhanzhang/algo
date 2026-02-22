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

public class LT0328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode dummyEven = new ListNode(0);
        ListNode dummyOdd = new ListNode(0);
        ListNode evenCur = dummyEven, oddCur = dummyOdd, cur = head;
        int index = 1;
        while (cur != null) {
            if (index % 2 == 0) {   // 偶数
                oddCur.next = cur;
                oddCur = oddCur.next;
            } else {
                evenCur.next = cur;
                evenCur = evenCur.next;
            }
            index++;
            cur = cur.next;
        }
        evenCur.next = dummyOdd.next;
        oddCur.next = null;
        return dummyEven.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.buildListNode(new Integer[]{1, 2, 3, 4, 5});
        LT0328 lt = new LT0328();
        ListUtils.printListNode(lt.oddEvenList(head));
    }

}
