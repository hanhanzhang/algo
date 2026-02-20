package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.TreeNode;
import com.sdu.algorithm.utils.TreeUtils;
import java.util.Stack;

public class LT0173 {

  public static class BSTIterator {

    private TreeNode current;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
      current = root;
      stack = new Stack<>();
      // 左序遍历, 使用栈
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
    }

    public int next() {
      TreeNode node = stack.pop();
      // 节点的所有右子树入栈
      current = node.right;
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      return node.val;
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }

  }

  public static void main(String[] args) {
    TreeNode root = TreeUtils.buildTree(new Integer[] {7, 3, 15, null, null, 9, 20});
    BSTIterator iterator = new BSTIterator(root);

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
