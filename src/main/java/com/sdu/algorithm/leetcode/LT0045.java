package com.sdu.algorithm.leetcode;

import java.util.Arrays;

public class LT0045 {

    public int jump(int[] nums) {
        // dp[i]: 表示从i跳到n-1索引位置所需要最小跳动次数
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = 0;
                continue;
            }
            if (nums[i] + i >= nums.length - 1) {
                dp[i] = 1;
            } else {
                // (i, num[i] + i) 区间选择最小值
                boolean selected = false;
                for (int j = i + 1; j <= nums[i] + i; j++) {
                    if (dp[j] == 0) {
                        continue;
                    }
                    selected = true;
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
                if (!selected) {
                    dp[i] = 0;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LT0045 lt = new LT0045();
        System.out.println(lt.jump(new int[]{2,3,0,1,4}));
    }
}
