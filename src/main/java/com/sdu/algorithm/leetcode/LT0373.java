package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LT0373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 笛卡尔积 => 矩阵, 转变为LT0378解法
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[]{nums1[0] + nums2[i], i, 0});
        }
        int col = nums1.length;
        for (int i = 0; i < k; i++) {
            int[] ele = queue.poll();
            if (ele[2] != col - 1) {
                int row = ele[1];
                int newCol = ele[2] + 1;
                queue.offer(new int[] {nums2[row] + nums1[newCol], row, newCol});
            }
            List<Integer> result = new ArrayList<>();
            result.add(nums1[ele[2]]);
            result.add(nums2[ele[1]]);
            ans.add(result);
        }
        return ans;
    }

    public static void main(String[] args) {
        LT0373 lt = new LT0373();
        System.out.println(lt.kSmallestPairs(new int[]{1,2,4,5,6}, new int[]{3,5,7,9}, 3));
    }

}
