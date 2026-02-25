package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0189 {

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        // [1,2,3,4,5,6,7], k = 3
        // 翻转数组: [7, 6, 5, 4, 3, 2, 1]
        // 翻转[0, k mod (n-1)]
        // 翻转[k mod (n -1), n -1]
        int len = nums.length;
        // 防止 k > len
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void main(String[] args) {
        LT0189 lt = new LT0189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        lt.rotate(nums, 3);
        ArrayUtils.printArray(nums);
    }

}
