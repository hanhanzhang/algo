package com.sdu.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LT0290 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        int j = 0;
        for (char c : pattern.toCharArray()) {
            String word = p2s.get(c);
            String newWord = words[j++];
            if (word == null) {
                Character ch = s2p.get(newWord);
                if (ch != null) {
                    return false;
                }
                s2p.put(newWord, c);
                p2s.put(c, newWord);
            } else if (!newWord.equals(word)) {
                return false;
            }
        }
        return j == words.length;
    }

    public static void main(String[] args) {
        LT0290 lt = new LT0290();
        System.out.println(lt.wordPattern("abba", "dog cat cat fish"));
        System.out.println(lt.wordPattern("abba", "dog cat cat dog"));
    }
}
