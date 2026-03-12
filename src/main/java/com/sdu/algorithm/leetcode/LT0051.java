package com.sdu.algorithm.leetcode;

import com.sdu.algorithm.utils.ListUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LT0051 {

    private boolean matched(List<Integer> ret, int row, int col) {
        // 判断[0, row - 1]是否有皇后放置在col列
        // 判断斜线是否有放置皇后
        int preRow = 0;
        for (int pos : ret) {
            int distance = row - preRow;
            if (pos == col || pos == col - distance || pos == col + distance) {
                return false;
            }
            preRow += 1;
        }
        return true;
    }

    // 对于第num行的皇后, 可选择 n - num - 1 列, 故记录已选择列进行剪枝
    private void dfs(int n, int num, List<List<String>> res, List<Integer> ret, Set<Integer> cols) {
        if (num == n) {
            List<String> result = new LinkedList<>();
            for (int row = 0; row < n; row++) {
                int col = ret.get(row);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == col) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                result.add(sb.toString());
            }
            res.add(result);
            return;
        }
        // 第num个皇后选择位置(即: num行), 选择列位置
        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) {
                continue;
            }
            cols.add(col);
            // 判断num皇后是否可放置在col处
            boolean matched = matched(ret, num, col);
            if (matched) {
                ret.add(col);
                dfs(n, num + 1, res, ret, cols);
                // 回溯
                ret.remove(ret.size() - 1);
            }
            cols.remove(col);
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        dfs(n, 0, res, new LinkedList<>(), new HashSet<>());
        return res;
    }

    public static void main(String[] args) {
        LT0051 lt = new LT0051();
        ListUtils.printList(lt.solveNQueens(4));
        ListUtils.printList(lt.solveNQueens(1));
    }
}
