package com.sdu.algorithm.leetcode;

public class LT0138 {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // A -> B -> C: A -> A' -> B -> B' -> C -> C'
        Node cursor = head;
        while (cursor != null) {
            Node newNode = new Node(cursor.val);
            Node temp = cursor.next;
            cursor.next = newNode;
            newNode.next = temp;
            cursor = temp;
        }
        cursor = head;
        while (cursor != null) {
            if (cursor.random != null) {
                cursor.next.random = cursor.random.next;
            }
            cursor = cursor.next.next;
        }

        Node dummy = new Node(0);
        Node cur = dummy;
        cursor = head;
        while (cursor != null) {
            cur.next = cursor.next;          // 复制节点加入拷贝链表
            cur = cur.next;
            cursor.next = cur.next;          // 恢复原链表 next
            cursor = cursor.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
