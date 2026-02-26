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

//    private static ListNode sortList(ListNode head) {
//        ListNode dumpNode = new ListNode(-1);
//        dumpNode.next = head;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode ret = cur.next;
//            if (ret == null) {
//                break;
//            }
//            if (cur.val <= ret.val) {
//                cur = cur.next;
//            } else {
//                cur.next = ret.next;
//                // (dumpNode, cur)寻找第一个比ret节点大的节点
//                ListNode pos = dumpNode.next;
//                ListNode pre = dumpNode;
//                while (pos != cur) {
//                    if (pos.val < ret.val) {
//                        pre = pos;
//                        pos = pos.next;
//                    } else {
//                        break;
//                    }
//                }
//                ret.next = pos;
//                pre.next = ret;
//            }
//        }
//        return dumpNode.next;
//    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {     // 断开中间节点
            head.next = null;
            return head;
        }
        // 找到中间节点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        // 递归分
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(mid, tail);
        // 合并有序数组
        return merge(l1, l2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        // head1, head2是有序列表
        ListNode dummyHead = new ListNode(0);
        ListNode cur1 = head1, cur2 = head2, cur = dummyHead;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            } else if (cur1 != null) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        return dummyHead.next;
    }


    public ListNode sortList(ListNode head) {
        // 排序算法: n*log(n)的算法有归并排序、快排, 这里使用归并排序(分左右, 合并左右)
        return sortList(head, null);
    }

    public static void main(String[] args) {
        LT0148 lt = new LT0148();
        ListUtils.printListNode(lt.sortList(ListUtils.buildListNode(new Integer[]{4, 2, 1, 3})));
        ListUtils.printListNode(lt.sortList(ListUtils.buildListNode(new Integer[]{8, 9, 5, 10, 3})));
        ListUtils.printListNode(lt.sortList(ListUtils.buildListNode(new Integer[]{-1, 5, 3, 4, 0})));
        ListUtils.printListNode(lt.sortList(ListUtils.buildListNode(new Integer[]{})));
    }

}
