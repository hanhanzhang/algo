package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;

public class LT0114 {

    private TreeNode[] _flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] lr = _flatten(root.left);
        TreeNode[] rr = _flatten(root.right);
        if (lr == null && rr == null) {
            return new TreeNode[] {root, root};
        } else if (lr != null && rr != null) {
            root.left = null;
            root.right = lr[0];
            lr[0].left = null;
            lr[1].right = rr[0];
            return new TreeNode[] {root, rr[1]};
        } else if (lr != null) {
            root.left = null;
            root.right = lr[0];
            return new TreeNode[] {root, lr[1]};
        } else {
            root.right = rr[0];
            return new TreeNode[] {root, rr[1]};
        }
    }

    public void flatten(TreeNode root) {
        _flatten(root);
    }

    public static void main(String[] args) {
        LT0114 lt = new LT0114();
        lt.flatten(TreeUtils.buildTree(new Integer[] {1,2,5,3,4,null,6}));
    }
}
