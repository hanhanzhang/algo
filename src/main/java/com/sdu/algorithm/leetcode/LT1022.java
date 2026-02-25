package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

import java.util.ArrayList;

public class LT1022 {

    private int visitTree(TreeNode root, ArrayList<Integer> stack) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            int sum = root.val;
            int cnt = 1;
            for (int i = stack.size() - 1; i >= 0; i--) {
                int val = stack.get(i);
                sum = sum + (val << cnt);
                cnt++;
            }
            return sum;
        }
        stack.add(root.val);
        int left = visitTree(root.left, stack);
        int right = visitTree(root.right, stack);
        // 回溯
        stack.remove(stack.size() - 1);
        return left + right;
    }

    public int sumRootToLeaf(TreeNode root) {
        ArrayList<Integer> stack = new ArrayList<>();
        return visitTree(root, stack);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{1,0,1,0,1,0,1});
        LT1022 lt1022 = new LT1022();
        System.out.println(lt1022.sumRootToLeaf(root));
    }
}
