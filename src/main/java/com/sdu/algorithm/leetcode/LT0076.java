package com.sdu.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LT0076 {

    private boolean matched(Map<Character, Integer> ori, Map<Character, Integer> window) {
        if (ori.size() != window.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : window.entrySet()) {
            if (ori.get(entry.getKey()) > entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        Map<Character, Integer> ori = new HashMap<>();
        for(char c : t.toCharArray()){
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0, len = s.length(), minL = -1, minR = -1, min = Integer.MAX_VALUE;
        while (right < len) {
            char ch = s.charAt(right++);
            if (ori.containsKey(ch)) {
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
            }
            // 判断是否匹配
            while (matched(ori, windows) && left < right) {
                if (minL == -1 || min > right - left) {
                    minL = left;
                    minR = right;
                    min = right - left;
                }
                // 移除
                char rc = s.charAt(left++);
                if (windows.containsKey(rc)) {
                    int cnt = windows.get(rc);
                    if (cnt == 1) {
                        windows.remove(rc);
                    } else {
                        windows.put(rc, cnt - 1);
                    }
                }
            }
        }
        return minL == -1 ? "" : s.substring(minL, minR);
    }


    public static void main(String[] args) {
        LT0076 lt = new LT0076();
        System.out.println(lt.minWindow("ADOBECODEBANC", "ABC"));
    }

}
