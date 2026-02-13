package com.sdu.algorithm.leetcode;

public class LT0383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LT0383 lt = new LT0383();
        System.out.println(lt.canConstruct("aa", "aab"));
    }
}
