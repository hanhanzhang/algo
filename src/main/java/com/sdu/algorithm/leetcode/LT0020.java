package com.sdu.algorithm.leetcode;

import java.util.Stack;

public class LT0020 {

  private static boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for (char c : s.toCharArray()) {
          switch (c) {
              case '(':
              case '[':
              case '{':
                  stack.push(c);
                  break;
              case ')':
                  if (stack.isEmpty() || stack.pop() != '(') {
                      return false;
                  }
                  break;
              case ']':
                  if (stack.isEmpty() || stack.pop() != '[') {
                      return false;
                  }
                  break;
              case '}':
                  if (stack.isEmpty() || stack.pop() != '{') {
                      return false;
                  }
                  break;
          }
      }
      return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    System.out.println(isValid("(]"));
  }

}
