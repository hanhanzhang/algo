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

public class LT0234II {

    private static ListNode frontPointer;

    private static boolean recursivelyCheck(ListNode current) {
        if (current == null)
            return true;
        if (!recursivelyCheck(current.next) || current.val != frontPointer.val) {
            return false;
        }

        frontPointer = frontPointer.next;
        return true;
    }

    private static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[]{1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[]{1, 2})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[]{1, 2, 1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[]{1, 2, 2, 1})));
        System.out.println(isPalindrome(ListUtils.buildListNode(new Integer[]{1, 1, 2, 1})));
    }

}
