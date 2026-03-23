package com.sdu.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LT0202 {

    private int nextNum(int n) {
        int sum = 0;
        while (n != 0) {
            int m = n %10;
            n /= 10;
            sum += m * m;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(n != 1) {
            int next = nextNum(n);
            if(visited.contains(next)) {
                return false;
            }
            visited.add(next);
            n = next;
        }
        return true;
    }

    public static void main(String[] args) {
        LT0202 lt = new LT0202();
        System.out.println(lt.isHappy(19));
        System.out.println(lt.isHappy(2));
    }

}
