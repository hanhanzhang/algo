package com.sdu.algorithm.leetcode;

public class LT1689 {

    public int minPartitions(String n) {
        int res = 0;
        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        LT1689 lt = new LT1689();
        System.out.println(lt.minPartitions("27346209830709182346"));
    }

}
