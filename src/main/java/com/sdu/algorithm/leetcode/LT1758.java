package com.sdu.algorithm.leetcode;

public class LT1758 {

    public int minOperations(String s) {
        // 思维模式: 逆向思维和目标导向, 不要考虑前后对比
        // 任何字符串都会变为 101010 或 010101, 也就是说要么奇数为是1, 要么是偶数位是1
        char[] arr = s.toCharArray();
        int res1 = 0, res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            // 奇数位是1, 偶数未是0
            res1 += (i & 1) == 1 ? (arr[i] == '1' ? 0 : 1) : (arr[i] == '0' ? 0 : 1);
            // 奇数位是0, 偶数位是1
            res2 += (i & 1) == 1 ? (arr[i] == '0' ? 0 : 1) : (arr[i] == '1' ? 0 : 1);
        }
        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
        LT1758 lt = new LT1758();
        System.out.println(lt.minOperations("10010100"));
    }

}
