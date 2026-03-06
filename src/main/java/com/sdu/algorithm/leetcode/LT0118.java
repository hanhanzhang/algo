package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class LT0118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ant = new ArrayList<>();
            List<Integer> pre = i >= 1 ? res.get(i - 1) : null;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || pre == null) {
                    ant.add(1);
                    continue;
                }
                ant.add(pre.get(j - 1) + pre.get(j));
            }
            res.add(ant);
        }
        return res;
    }

    public static void main(String[] args) {
        LT0118 lt = new LT0118();
        ListUtils.printList(lt.generate(5));
    }

}
