package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LT0438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        int[] scount = new int[26];
        int[] pcount = new int[26];
        int sLen = s.length(), pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(scount, pcount)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            // 第一个窗口已经判断, 则判断下一个窗口
            scount[s.charAt(i) - 'a']--;
            scount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(scount, pcount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LT0438 lt0438 = new LT0438();
        System.out.println(lt0438.findAnagrams("cbaebabacd", "abc"));
    }

}
