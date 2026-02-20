package com.sdu.algorithm.leetcode;

public class LT0392 {

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length(), i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        LT0392 lt = new LT0392();
        System.out.println(lt.isSubsequence("abc", "ahbgdc"));
    }

}
