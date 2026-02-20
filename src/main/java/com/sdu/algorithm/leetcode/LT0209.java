package com.sdu.algorithm.leetcode;

public class LT0209 {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = nums[i];
        while (j < nums.length) {
            if (sum < target) {
                if (j == nums.length - 1) {
                    break;
                }
                j += 1;
                sum += nums[j];
            } else {
                do {
                    minLen = Math.min(minLen, j - i + 1);
                    sum -= nums[i];
                    i += 1;
                } while (sum >= target);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        LT0209 lt0209 = new LT0209();
        System.out.println(lt0209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(lt0209.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

}
