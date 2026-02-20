package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ArrayUtils;

public class LT0167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        // never got here
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        LT0167 lt = new LT0167();
        ArrayUtils.printArray(lt.twoSum(new int[] {2,7,11,15}, 9));
        ArrayUtils.printArray(lt.twoSum(new int[] {2,3,4}, 6));
    }
}

