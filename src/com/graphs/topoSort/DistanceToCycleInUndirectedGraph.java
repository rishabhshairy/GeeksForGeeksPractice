package com.graphs.topoSort;

import java.util.*;

public class DistanceToCycleInUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {2, 6}, {6, 7}, {6, 8}, {0, 3}, {3, 4}, {3, 5}};
        int n = 9;
        distanceToCycleMy(n, edges);
    }

    public static int[] distanceToCycleMy(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            adjacencyList.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println(adjacencyList);

        // add nodes with in-degree 1
        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adjacencyList.get(i).size() == 1) {
                nodeQueue.offer(i);
            }
        }
        System.out.println(nodeQueue);

        Deque<Integer> removedNodes = new ArrayDeque<>();
        int[] freq = new int[n];
        // now remove the edges
        while (!nodeQueue.isEmpty()) {
            Integer curr = nodeQueue.poll();
            removedNodes.push(curr);

            for (Integer adjNode : adjacencyList.get(curr)) {
                adjacencyList.get(adjNode).remove(curr);
                freq[curr] = adjNode;
                if (adjacencyList.get(adjNode).size() == 1) {
                    nodeQueue.offer(adjNode);
                }
            }
        }
        System.out.println(removedNodes);
        for (int num : freq) {
            System.out.print(num + " ");
        }
        System.out.println();
        while (!removedNodes.isEmpty()) {
            int index = removedNodes.pop();
            System.out.println(index);
            distance[index] = distance[freq[index]] + 1;
        }
        System.out.println();
        for (int num : distance) {
            System.out.print(num + " ");
        }
        return distance;
    }
}
