package com.graphs.minSpanningTree;

import java.util.ArrayList;
import java.util.List;

/**
 * GFG https://www.geeksforgeeks.org/problems/number-of-provinces/1
 */
public class NoOfProvincesDFS {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int components = 0;
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(i, adj, visited);

            }
        }
        return components;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            if (adj.get(node).get(i) == 1 && visited[i] == 0) {
                dfs(i, adj, visited);
            }
        }
    }
}
