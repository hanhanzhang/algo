package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;

public class LT0108 {

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (left > right) {
            return null;
        }
        int mid  = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        LT0108 lt0108 = new LT0108();
        TreeNode root = lt0108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(root.val);
    }
}
