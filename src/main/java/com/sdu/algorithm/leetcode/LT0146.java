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

import java.util.HashMap;
import java.util.Map;

public class LT0146 {

    static class LRUCache {

        // 最近很少使用
        private Map<Integer, Node> cache;
        private Node head;
        private Node tail;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = tail;
            this.tail.pre = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 放置链表的头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                if (cache.size() >= capacity) {
                    // 移除尾部元素
                    removeTailNode();
                }
                addToHead(new Node(key, value));
            }
        }

        private void addToHead(Node node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            cache.put(node.key, node);
        }

        private void moveToHead(Node node) {
            if (node.pre == head)
                return;
            Node pre = node.pre;
            pre.next = node.next;
            node.next.pre = pre;
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        private void removeTailNode() {
            Node remove = tail.pre;
            if (remove == head)
                return;
            remove.pre.next = tail;
            tail.pre = remove.pre;
            cache.remove(remove.key);
        }

        private static class Node {

            int key, value;
            Node pre, next;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(2)); // 3
    }

}
