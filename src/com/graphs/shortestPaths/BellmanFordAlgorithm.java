package com.graphs.shortestPaths;

import java.util.Arrays;

public class BellmanFordAlgorithm {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e8);
        distance[src] = 0;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];

                if (distance[u] != 1e8 && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Nth relaxation to check Negative Cycles
        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];

            if (distance[u] != 1e8 && distance[u] + weight < distance[v]) {
                return new int[]{-1};
            }
        }

        return distance;
    }
}
