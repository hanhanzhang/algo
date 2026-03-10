package com.sdu.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LT0032 {


    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        LT0032 lt = new LT0032();
        System.out.println(lt.longestValidParentheses("(()"));
        System.out.println(lt.longestValidParentheses(")()())"));
        System.out.println(lt.longestValidParentheses(""));
        System.out.println(lt.longestValidParentheses("()(())"));
        System.out.println(lt.longestValidParentheses("(()()"));
        System.out.println(lt.longestValidParentheses(")(((((()())()()))()(()))("));
    }
}
