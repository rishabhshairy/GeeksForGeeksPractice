package com.graphs.bfsDfs;

import java.util.ArrayList;

public class CycleCheckDirectedDFS {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[V];
        int[] dfsVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (checkDFS(adj, visited, dfsVisited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDFS(ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dfsVisited, int node) {
        visited[node] = 1;
        dfsVisited[node] = 1;

        for (Integer adjNode :
                adj.get(node)) {
            if (visited[adjNode] == 0) {
                if (checkDFS(adj, visited, dfsVisited, adjNode)) {
                    return true;
                }
            } else if (dfsVisited[adjNode] == 1) {
                return true;
            }
        }
        dfsVisited[node] = 0;
        return false;
    }
}
