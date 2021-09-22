package com.leetcode.bfs_dfs;

import java.util.ArrayList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] visited = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (checkCycle(visited, graph, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCycle(int[] visited, ArrayList<ArrayList<Integer>> graph, int course) {
        visited[course] = -1;
        for (Integer i :
                graph.get(course)) {
            if (visited[i] == -1) {
                return true;
            } else if (visited[i] == 0) {
                if (checkCycle(visited, graph, i)) {
                    return true;
                }
            }
        }
        visited[course] = 1;
        return false;
    }
}
