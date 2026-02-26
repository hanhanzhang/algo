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

public class LT0234 {

//    private static boolean isPalindrome(ListNode head) {
//        if (head == null)
//            return false;
//        Stack<ListNode> stack = new Stack<>();
//        ListNode cur = head;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.next;
//        }
//
//        ListNode tail = stack.pop();
//        while (head != null) {
//            if (head.val != tail.val)
//                return false;
//            if (head == tail || head.next == tail)
//                break;
//            head = head.next;
//            tail = stack.pop();
//        }
//        return true;
//    }

    public boolean isPalindrome(ListNode head) {
        // 进阶: o(1)空间复杂度, 则可以翻转后半部分, 然后再比较
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转, 区分奇偶
        ListNode dummy = new ListNode(0);
        ListNode cur = fast == null ? slow : slow.next;
        while (cur != null) {
            ListNode temp = dummy.next;
            dummy.next = cur;
            cur = cur.next;
            dummy.next.next = temp;
        }
        // 判断是否是回文
        ListNode first = head;
        ListNode second = dummy.next;
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }



    public static void main(String[] args) {
        LT0234 lt = new LT0234();
        System.out.println(lt.isPalindrome(ListUtils.buildListNode(new Integer[]{1})));
        System.out.println(lt.isPalindrome(ListUtils.buildListNode(new Integer[]{1, 2})));
        System.out.println(lt.isPalindrome(ListUtils.buildListNode(new Integer[]{1, 2, 1})));
        System.out.println(lt.isPalindrome(ListUtils.buildListNode(new Integer[]{1, 2, 2, 1})));
        System.out.println(lt.isPalindrome(ListUtils.buildListNode(new Integer[]{1, 1, 2, 1})));
    }

}
