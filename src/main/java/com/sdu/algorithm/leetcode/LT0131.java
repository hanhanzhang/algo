package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LT0131 {

    private boolean isPalindromic(String s, int l, int h) {
        while (l < h) {
            if (s.charAt(l++) != s.charAt(h--)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(String s, int offset, boolean[][] dp, List<List<String>> res, List<String> ret) {
        if (offset == s.length()) {
            res.add(new ArrayList<>(ret));
            return;
        }
        // 这里太多重复计算: 子字符串是否是回文
        for (int i = offset; i < s.length(); i++) {
            if (dp[offset][i]) {
                ret.add(s.substring(offset, i + 1));
                dfs(s, i + 1, dp, res, ret);
                ret.remove(ret.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        // 1. 计算s(i) - s(j)是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = isPalindromic(s, i, j);
            }
        }
        dfs(s, 0, dp, res, ret);
        return res;
    }

    public static void main(String[] args) {
        LT0131 lt = new LT0131();
        System.out.println(lt.partition("aab"));
    }

}
