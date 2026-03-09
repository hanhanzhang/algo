package com.sdu.algorithm.leetcode;

import java.util.HashSet;

public class LT1980 {


    public String findDifferentBinaryString(String[] nums) {
        // 转化为: 0, 2^n - 1, 只有这个整数不在这个区间则转为二进制便是
        HashSet<Integer> vals = new HashSet<>();
        for (String num : nums) {
            vals.add(Integer.parseInt(num, 2));
        }
        int val = 0;
        while (vals.contains(val)) {
            val++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(val));
        // 用0补齐位数
        while (sb.length() < nums[0].length()) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LT1980 lt = new LT1980();
        System.out.println(lt.findDifferentBinaryString(new String[] {"01","10"}));
    }

}
