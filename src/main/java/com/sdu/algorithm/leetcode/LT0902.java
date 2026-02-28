package com.sdu.algorithm.leetcode;

public class LT0902 {

    private int count = 0;

    private int numLength(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += 1;
            n = n / 10;
        }
        return cnt;
    }

    private int numPre(int n, int len, int pre) {
        for (int i = 0; i < len - pre; i++) {
            n = n / 10;
        }
        return n;
    }

    private void dfs(String[] digits, int n, int len, int curNum, int index) {
        if (index == len) {
            count += curNum <= n ? 1 : 0;
            return;
        }
        for (String digit : digits) {
            curNum = curNum * 10 + digit.charAt(0) - '0';
            // 剪枝逻辑:
            // 1. [0, index]与n相同, 则继续
            // 2. [0, index]相比n小, 则直接计算
            // 3. [0, index]相比n大, 则终结计算
            int pre = numPre(n, len, index + 1);
            if (curNum > pre) {
                return;
            }
            if (curNum < pre) {
                count = count + (int) Math.pow(digits.length, len - index - 1);
                // 回溯
                curNum = curNum / 10;
                continue;
            }
            dfs(digits, n, len, curNum, index + 1);
            curNum = curNum / 10;
        }
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 1. 计算n长度
        int len = numLength(n);
        // 2. 数字可重复选(digits不含0)
        for (int i = 0; i < len - 1; i++) {
            count = count + (int) Math.pow(digits.length, i + 1);
        }
        // 3. 选择与n同等位数数字
        dfs(digits, n, len, 0, 0);
        return count;
    }


    public static void main(String[] args) {
        LT0902 lt = new LT0902();
        System.out.println(lt.atMostNGivenDigitSet(new String[]{"3","4","8"}, 4));
    }

}
