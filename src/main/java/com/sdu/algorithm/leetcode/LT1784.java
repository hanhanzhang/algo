package com.sdu.algorithm.leetcode;

public class LT1784 {

    public boolean checkOnesSegment(String s) {
        int preIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (preIndex == i || preIndex + 1 == i) {
                    preIndex = i;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LT1784 lt = new LT1784();
        System.out.println(lt.checkOnesSegment("1001"));
        System.out.println(lt.checkOnesSegment("110"));
    }

}
