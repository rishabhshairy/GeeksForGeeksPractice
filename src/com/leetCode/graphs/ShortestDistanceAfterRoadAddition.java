package com.leetCode.graphs;

import java.util.*;

/**
 * LC 3243
 */
public class ShortestDistanceAfterRoadAddition {
    public static void main(String[] args) {
//        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[][] queries = {{0, 3}, {0, 2}};
        ShortestDistanceAfterRoadAddition obj = new ShortestDistanceAfterRoadAddition();
        obj.shortestDistanceAfterQueries(4, queries);
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // step 1 --> prepare base adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            adjacencyList.get(i).add(i + 1);
        }

        // update graph for each query
        for (int i = 0; i < queries.length; i++) {
            updateGraph(adjacencyList, queries[i][0], queries[i][1]);

            // find the shortest path after each update
            int[] distance = new int[n];
            Arrays.fill(distance, (int) 1e9);
            distance[0] = 0;
            findShortestPath(adjacencyList, distance);
            result[i] = distance[n - 1];
        }

        return result;
    }

    private void findShortestPath(List<List<Integer>> adjacencyList, int[] distance) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            int currNode = nodeQueue.poll();

            for (Integer adjNode : adjacencyList.get(currNode)) {

                if (1 + distance[currNode] < distance[adjNode]) {
                    distance[adjNode] = 1 + distance[currNode];
                    nodeQueue.offer(adjNode);
                }
            }
        }
    }

    private void updateGraph(List<List<Integer>> adjacencyList, int src, int dest) {
        adjacencyList.get(src).add(dest);
    }
}
