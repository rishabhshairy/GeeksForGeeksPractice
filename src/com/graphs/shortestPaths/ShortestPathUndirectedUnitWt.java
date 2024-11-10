package com.graphs.shortestPaths;

import java.util.*;

public class ShortestPathUndirectedUnitWt {
    static class Vertex {
        int node;
        int dist;

        public Vertex(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        List<List<Integer>> adjacencyList = prepareGraph(edges, n, m);

        // Do simple BFS
        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);

        Queue<Vertex> nodeQueue = new LinkedList<>();
        nodeQueue.offer(new Vertex(src, 0));
        distance[src] = 0;

        while (!nodeQueue.isEmpty()) {

            Vertex curr = nodeQueue.poll();

            for (Integer adjNode : adjacencyList.get(curr.node)) {
                if (1 + distance[curr.node] < distance[adjNode]) {
                    distance[adjNode] = 1 + distance[curr.node];
                    nodeQueue.offer(new Vertex(adjNode, distance[adjNode]));
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == 1e9) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private List<List<Integer>> prepareGraph(int[][] edges, int n, int m) {
        List<List<Integer>> adjacency = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adjacency.get(edges[i][0]).add(edges[i][1]);
            adjacency.get(edges[i][1]).add(edges[i][0]);
        }
        return adjacency;
    }
}
