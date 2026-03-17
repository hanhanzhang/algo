package com.sdu.algorithm.leetcode;

import java.util.PriorityQueue;

public class LT0295 {

    static class MedianFinder {

        private int cnt;
        // 左边 - 右边 <= 1
        // 大顶堆
        private final PriorityQueue<Integer> left;
        // 小顶堆
        private final PriorityQueue<Integer> right;

        public MedianFinder() {
            cnt = 0;
            left = new PriorityQueue<>((a, b) -> b - a);
            right = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            cnt++;
            if (left.isEmpty() || left.peek() > num) {
                left.offer(num);
                swap(left, right);
            } else  {
                right.offer(num);
                swap(left, right);
            }
        }

        public double findMedian() {
            if ((cnt & 1) == 1) {       //
                return (double) left.peek();
            }
            return (left.peek() + right.peek()) / 2.0;
        }

        private void swap(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            if (left.size() - right.size() >= 2) {
                right.offer(left.poll());
            } else if (right.size() - left.size() >= 1) {
                left.offer(right.poll());
            }
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
