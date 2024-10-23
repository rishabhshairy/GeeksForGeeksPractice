package com.graphs.bfsDfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionBFS {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}};

        System.out.println(cycleDetection(edges, 3, 3));
    }

    static class Node {
        int currNode;
        int parentNode;

        public Node(int currNode, int parentNode) {
            this.currNode = currNode;
            this.parentNode = parentNode;
        }
    }


    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        List<List<Integer>> adjacencyList = generateAdjList(edges, n);

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (checkCycleBFS(i, visited, adjacencyList)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean checkCycleBFS(int i, boolean[] visited, List<List<Integer>> adjacencyList) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Node(i, -1));
        visited[i] = true;

        while (!nodeQueue.isEmpty()) {
            int currNode = nodeQueue.peek().currNode;
            int parentNode = nodeQueue.peek().parentNode;
            nodeQueue.poll();

            for (Integer adjNode : adjacencyList.get(currNode)) {
                if (!visited[adjNode]) {
                    nodeQueue.offer(new Node(adjNode, currNode));
                    visited[adjNode] = true;
                } else if (adjNode != parentNode) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<List<Integer>> generateAdjList(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
}
