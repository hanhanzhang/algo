package com.sdu.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LT0046 {

    private void permute(int[] nums, boolean[] selected, int round, List<List<Integer>> ans, List<Integer> res) {
        if (round == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if (round == 0) {
            res = new ArrayList<>();
        }
        for(int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            res.add(nums[i]);
            permute(nums, selected, round + 1, ans, res);
            // 回溯(即当前元素未选择)
            selected[i] = false;
            res.remove(res.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // 回溯算法: 枚举, 若某个路径符合则加入计算结果, 否则回溯寻找另一条路径
        List<List<Integer>> ans = new LinkedList<>();
        permute(nums, new boolean[nums.length], 0, ans, null);
        return ans;
    }


    public static void main(String[] args) {
        LT0046 lt = new LT0046();
        System.out.println(lt.permute(new int[] {1, 2, 3}));
    }

}
