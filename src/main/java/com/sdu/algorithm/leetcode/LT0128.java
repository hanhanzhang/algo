package com.sdu.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LT0128 {

    public int longestConsecutive(int[] nums) {
        // 可能存在重复元素
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            // 题目要求时间复杂度为o(n), 故需要找到连续子序列的开始
            if (!set.contains(num - 1)) {   // 子序列的开始
                int count = 1;
                int next = num + 1;
                while (set.contains(next)) {
                    count++;
                    next = next + 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LT0128 lt = new LT0128();
        System.out.println(lt.longestConsecutive(new int[] {100,4,200,1,3,2}));
    }

}
