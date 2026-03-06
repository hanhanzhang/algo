package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT0763 {

    public List<Integer> partitionLabels(String s) {
        // 参考: Leetcode 45
        // 记录每个字符在字符串最大索引
        int[] positions = new int[26];
        Arrays.fill(positions, -1);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
//            positions[index] = Math.max(positions[index], i);
            // 这里没有必要比较大小
            positions[index] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, maxPosition = 0;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            maxPosition = Math.max(maxPosition, positions[index]);
            if (i >= maxPosition) {
                ans.add(maxPosition - start + 1);
                start = i + 1;
                maxPosition = 0;
            }
        }
        if (start < len) {
            ans.add(s.length() - start);
        }
        return ans;
    }


    public static void main(String[] args) {
        LT0763 lt = new LT0763();
        System.out.println(lt.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(lt.partitionLabels("eccbbbbdec"));
    }
}
