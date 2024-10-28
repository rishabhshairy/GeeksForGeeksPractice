package com.graphs.topoSort;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 207
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseScheduling1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // considering courses as vertex of graph
        // and pre-req as directed edges
        // Approach --> Check cycle in the formed graph

        List<List<Integer>> adjacencyList = prepareDirectedGraph(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (checkCycleDFS(i, adjacencyList, visited, pathVisited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkCycleDFS(int currNode, List<List<Integer>> adjacencyList, boolean[] visited, boolean[] pathVisited) {
        visited[currNode] = true;
        pathVisited[currNode] = true;

        for (Integer adjNode : adjacencyList.get(currNode)) {
            if (!visited[adjNode]) {
                if (checkCycleDFS(adjNode, adjacencyList, visited, pathVisited)) {
                    return true;
                }

            } else if (pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[currNode] = false;
        return false;
    }

    private List<List<Integer>> prepareDirectedGraph(int[][] edges, int vertex) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        return adjacencyList;
    }
}
