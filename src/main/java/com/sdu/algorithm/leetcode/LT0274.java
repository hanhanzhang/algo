package com.sdu.algorithm.leetcode;

import java.util.Arrays;

public class LT0274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            int min = Math.min(citations[i], citations.length - i);
            h = Math.max(h, min);
        }
        return h;
    }

    public static void main(String[] args) {
        LT0274 lt = new LT0274();
        System.out.println(lt.hIndex(new int[] {3, 0, 6, 1, 5}));
        System.out.println(lt.hIndex(new int[] {1, 3, 1}));
    }

}
