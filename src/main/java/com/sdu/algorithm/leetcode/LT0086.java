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
        ListNode head = ListUtils.buildListNode(new Integer[] {1, 4, 3, 2, 5, 2});
        LT0086 lt = new LT0086();
        ListNode newHead = lt.partition(head, 3);
        ListUtils.printListNode(newHead);
    }
}
