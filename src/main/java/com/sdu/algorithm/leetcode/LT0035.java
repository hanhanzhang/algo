package com.sdu.algorithm.leetcode;

public class LT0035 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        LT0035 lt = new LT0035();
        System.out.println(lt.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(lt.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(lt.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

}
