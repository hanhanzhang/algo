package com.sdu.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LT0443 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        if (!dict.contains(endGene)) {
            return -1;
        }
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                // 穷尽
                for (int i = 0; i < 8; ++i) {
                    for (char key : keys) {
                        if (key == cur.charAt(i)) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(i, key);
                        String next = sb.toString();
                        if (dict.contains(next) && !visited.contains(next)) {
                            if (next.equals(endGene)) {
                                return step + 1;
                            }
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
                // 判断next则减少计算
//                if (cur.equals(endGene)) {
//                    return step;
//                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LT0443 lt = new LT0443();
        System.out.println(lt.minMutation("AACCGGTT", "AAACGGTA", new  String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }

}
