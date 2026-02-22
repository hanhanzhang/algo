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

package com.sdu.algorithm.utils;

import java.util.List;

public class ListUtils {

    public static ListNode buildListNode(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nodes[0]);
        ListNode cur = head;
        for (int i = 1; i < nodes.length; ++i) {
            ListNode node = new ListNode(nodes[i]);
            cur.next = node;
            cur = node;
        }

        return head;
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    public static <T> void printList(List<T> list) {
        if (list == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (T obj : list) {
            sb.append(obj).append(" ");
        }
        System.out.println(sb.toString());
    }

}
