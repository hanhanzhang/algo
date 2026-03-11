package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LT0127 {

    private boolean match(String word1, String word2) {
        int len = word1.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String next : words) {
                    if (!visited.contains(next) && match(next, word)) {
                        if (next.equals(endWord)) {
                            return step + 2;
                        }
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        LT0127 lt = new LT0127();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(lt.ladderLength("hit", "cog", wordList));
    }
}
