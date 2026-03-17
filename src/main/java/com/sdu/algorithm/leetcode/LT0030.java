package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LT0030 {

//    private boolean dfs(String s, int left, int right, int len, Map<String, Integer> wordCount, Map<String, Integer> visited) {
//        String word = s.substring(left, left + len);
//        Integer cnt = wordCount.get(word);
//        if (cnt == null) {
//            return false;
//        }
//        if (Objects.equals(visited.get(word), cnt)) {
//            return false;
//        }
//        visited.put(word, visited.getOrDefault(word, 0) + 1);
//        if (left + len == right) {
//            if (visited.size() != wordCount.size()) {
//                return false;
//            }
//            for(Map.Entry<String, Integer> entry : visited.entrySet()) {
//                if (!Objects.equals(entry.getValue(), wordCount.get(entry.getKey()))) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return dfs(s, left + len, right, len, wordCount, visited);
//    }
//
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> ans = new ArrayList<>();
//        int windowLen = words.length * words[0].length();
//        if (s.length() < windowLen) {
//            return ans;
//        }
//        Map<String, Integer> wordCount = new HashMap<>();
//        for (String word : words) {
//            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//        }
//        int left = 0, right = windowLen, length = words[0].length();
//        Map<String, Integer> visited = new HashMap<>();
//        while (right <= s.length()) {
//            boolean matched = dfs(s, left, right, length, wordCount, visited);
//            if (matched) {
//                ans.add(left);
//            }
//            left++;
//            right++;
//            visited.clear();
//        }
//        return ans;
//    }

    private boolean matched(Map<String, Integer> wordCount, Map<String, Integer> window) {
        if (window.size() != wordCount.size()) {
            return false;
        }
        for(Map.Entry<String, Integer> entry : window.entrySet()) {
            if (!Objects.equals(entry.getValue(), wordCount.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int windowLen = words.length * words[0].length();
        if (s.length() < windowLen) {
            return ans;
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int left = 0, right = windowLen, len = words[0].length();
        Map<String, Integer> window = new HashMap<>();
        while (right <= s.length()) {
            // 判断当前窗口是否符合, 则需要计数
            for (int i = left; i < right; i = i + len) {
                String word = s.substring(i, i + len);
                window.put(word, window.getOrDefault(word, 0) + 1);
            }
            if (matched(wordCount, window)) {
                ans.add(left);
            }
            left++;
            right++;
            window.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        LT0030 lt = new LT0030();
        ListUtils.printList(lt.findSubstring("a", new String[]{"a"}));
    }

}
