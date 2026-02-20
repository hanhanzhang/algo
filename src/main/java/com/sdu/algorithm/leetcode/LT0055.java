package com.sdu.algorithm.leetcode;

public class LT0055 {

    private static boolean canJump(int[] nums) {
        // 对于每个元素, 判断是否可以到尾部即可, 若存在则返回true
        // reach: 记录上一步可达到最远的距离
        int reach = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (reach < i) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[] {3, 2, 1, 0, 4}));
    }

}
