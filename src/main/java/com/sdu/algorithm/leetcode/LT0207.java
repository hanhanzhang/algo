package com.sdu.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT0207 {

//  private static boolean dfs(int parent, int course, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
//    if (graph == null) return false;
//    List<Integer> previousCourses = graph.get(course);
//    visited.add(course);
//    if (previousCourses == null || previousCourses.isEmpty()) return true;
//    // 先学课程中不应该包含parent, 否则返回false
//    for (int previousCourse : previousCourses) {
//      if (previousCourse == parent) return false;
//      if (visited.contains(previousCourse)) {
//        continue;
//      }
//      boolean ans = dfs(parent, previousCourse, graph, visited);
//      if (!ans) return false;
//    }
//    return true;
//  }
//
//  private static boolean canFinish(int numCourses, int[][] prerequisites) {
//    /*
//     * 本质: 判断是否存在环
//     * 注意: 本方法实现未暂存中间结果, 可保持中间结果节约计算时间(空间换时间)
//     * */
//    Map<Integer, List<Integer>> graph = new HashMap<>();
//    for (int i = 0; i < prerequisites.length; ++i) {
//      int course = prerequisites[i][0];
//      int preCourse = prerequisites[i][1];
//      List<Integer> previousCourses = graph.computeIfAbsent(course, key -> new ArrayList<>());
//      previousCourses.add(preCourse);
//    }
//    Set<Integer> visited = new HashSet<>();
//    for (int i = 0; i < numCourses; ++i) {
//      visited.clear();
//      boolean ans = dfs(i, i, graph, visited);
//      if (!ans) return false;
//    }
//
//    return true;
//  }


    @SuppressWarnings("unchecked")
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录每个节点的入度(即: 输入边数)
        int[] degree = new int[numCourses];
        // 记录每个节点出边(即: 每个节点输出边)
        List<Integer>[] edges = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            edges[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
            edges[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        // 已修课程数
        int cnt = 0;
        // 入度为零即无依赖课程, 则入队列
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int course = queue.remove();
                size -= 1;
                cnt += 1;
                // 下游节点的入度减一
                List<Integer> neighbours = edges[course];
                for (Integer neighbour : neighbours) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return cnt == numCourses;
    }

    public static void main(String[] args) {
        LT0207 lt = new LT0207();
        int[][] prerequisites1 = new int[][] {{1, 0}, {0, 1}};
        System.out.println(lt.canFinish(2, prerequisites1));

        int[][] prerequisites2 = new int[][] {{1, 0}};
        System.out.println(lt.canFinish(1, prerequisites2));
    }

}
