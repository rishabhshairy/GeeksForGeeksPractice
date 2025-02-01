package com.graphs.topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule4 {
    public static void main(String[] args) {
        int n = 3;
        int[][] prerequisites = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries = {{1, 0}, {1, 2}};
        CourseSchedule4 obj = new CourseSchedule4();
        obj.checkIfPrerequisite(n, prerequisites, queries);
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        List<List<Integer>> adjList = prepareGraph(numCourses, prerequisites);

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            result.add(isValid(u, v, adjList));

        }
        System.out.println(result);
        return result;
    }

    private Boolean isValid(int u, int v, List<List<Integer>> adjList) {
        int[] visited = new int[adjList.size()];
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.offer(u);

        while (!nodeQueue.isEmpty()) {
            Integer currNode = nodeQueue.poll();
            visited[currNode] = 1;

            if (currNode == v) {
                return true;
            }
            for (Integer adjNode : adjList.get(currNode)) {
                if (visited[adjNode] != 1) {
                    nodeQueue.offer(adjNode);
                }

            }
        }
        return false;
    }

    private List<List<Integer>> prepareGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] row : prerequisites) {
            adjList.get(row[0]).add(row[1]);
        }
        return adjList;
    }
}
