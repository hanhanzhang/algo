package com.sdu.algorithm.leetcode;

public class LT0041 {

    private void swap(int[]nums, int index) {
        int num = nums[index];
        int next = nums[num - 1];
        if (next == num) {
            nums[index] = -1;
            return;
        }
        nums[num - 1] = num;
        nums[index] = next;
    }

    public int firstMissingPositive(int[] nums) {
        // 最小正整数一定在[1, nums.length + 1]区间
        // 1. 按照元素放置对应索引处, 若是负数和零不做任何处理
        // 2. 若元素大于等于nums.length则抛弃(-1表示)
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index + 1 || nums[index] <= 0) {
                index++;
                continue;
            }
            if (nums[index] > nums.length) {
                nums[index] = -1;
                index++;
                continue;
            }
            swap(nums, index);
        }
        // [0, nums.length - 1] 找到第一个小于等于0的元素
        int num = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                num = i + 1;
                break;
            }
        }
        return num == -1 ? nums.length + 1 : num;
    }

    public static void main(String[] args) {
        LT0041 lt = new LT0041();
        System.out.println(lt.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(lt.firstMissingPositive(new int[]{1, 1}));
        System.out.println(lt.firstMissingPositive(new int[]{2, 1}));
    }

}
