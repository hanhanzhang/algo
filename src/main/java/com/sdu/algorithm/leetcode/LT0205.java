package com.sdu.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LT0205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Character replaced1 = map1.get(c1);
            if (replaced1 != null && replaced1 != c2) {
                return false;
            }
            Character replaced2 = map2.get(c2);
            if (replaced2 != null && replaced2 != c1) {
                return false;
            }
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        LT0205 lt = new LT0205();
        System.out.println(lt.isIsomorphic("badc", "baba"));
    }

}
